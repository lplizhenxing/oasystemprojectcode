package com.zszd.ai.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zszd.ai.pojo.Employee;
import com.zszd.ai.pojo.Page;
import com.zszd.ai.pojo.Workpoint;
import com.zszd.ai.service.employee.EmployeeServiceImpl;
import com.zszd.ai.service.workpoint.WorkPointService;
import com.zszd.ai.service.workpoint.WorkPointServiceImpl;
/**
 * 工分
 * @author lizx 20180103
 *
 */
@WebServlet(urlPatterns = { "/workpoint" }, name = "workpoint")
public class WorkPointServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ path + "/";
		HttpSession session = request.getSession();// 获取session
		String name = (String) session.getAttribute("login");
		String opr = request.getParameter("opr");
		WorkPointService workPointService = new WorkPointServiceImpl();
		PrintWriter out = response.getWriter();
		if ("add".equals(opr)) {
			String employeename = request.getParameter("employeename");
			String workpoint = request.getParameter("workpoint");
			String remarks = request.getParameter("remarks");
			Employee employee = new Employee();
			employee.setName(employeename);

			Workpoint wp = new Workpoint();
			wp.setWorkpoint(Integer.valueOf(workpoint));
			wp.setRemarks(remarks);
			
			try{
		         boolean flag = workPointService.addWorkPointRecord(employee,wp);
		         if (flag) {
			       		out.print("<script type='text/javascript'>");
			    		out.print("alert('当前工分记录提交成功，点击确认返回工分列表！');");
						out.print("location.href=\""+basePath+"workpoint?opr=search\";");
						out.print("</script>");
				  } else {
				        out.print("<script type='text/javascript'>");
			    		out.print("alert('当前工分记录提交失败，请重新添加！');");
						out.print("location.href=\""+basePath+"jsp/workpoint/workpointrecord_add.jsp\";");
						out.print("</script>");
				}	
			}catch(Exception e){
				    out.print("<script type='text/javascript'>");
		    		out.print("alert('当前工分记录提交失败，记录已经存在！');");
					out.print("location.href=\""+basePath+"workpoint?opr=search\";");
					out.print("</script>");
			}
		} else if ("search".equals(opr)) {
			String keywords = request.getParameter("keywords");
			if (keywords == null) {
				keywords = "";
			}

			//获取当前页的页码
			String currentPageNumStr = request
					.getParameter("currPageNum");
			int currentPageNum = 1;//默认当前页是第一页
			if (currentPageNumStr != null) {
				try {
					currentPageNum = Integer.parseInt(currentPageNumStr);
				} catch (Exception e) {//如果有字符串，就调到第一页
					currentPageNum = 1;
				}
			}

			//设置每页显示的数量
			String pageSizeStr = request.getParameter("pageSize");
			int pageSize = 8; // 默认每页显示10条记录
			if (pageSizeStr != null) {
				try {
					pageSize = Integer.parseInt(pageSizeStr);
				} catch (Exception e) {//如果有字符串，每页显示10条记录
					pageSize = 8;
				}
			}

			//设置总记录数
			int totalCount = workPointService
					.getWorkPointInfoCountLikeName(keywords);

			Page p = new Page();
			p.setPageSize(pageSize);
			p.setTotalCount(totalCount);


			//判断总页数小于当前页
			int totalPageNum = p.getTotalPageNum();
			if (currentPageNum > totalPageNum) {
				currentPageNum = totalPageNum;
			}
			
			if(currentPageNum<1){
			    currentPageNum=1;
			}
			p.setCurrentPageNum(currentPageNum);

			List<Workpoint> list = workPointService
					.queryWorkPointInfoLikeNamePage(p,keywords);
			request.setAttribute("list", list);
			request.setAttribute("keywords", keywords);
			request.setAttribute("p", p);

			request.getRequestDispatcher("jsp/workpoint/workpointrecord_list.jsp")
					.forward(request, response);
		}else if ("view".equals(opr)) {
			int employeeId =0;
			if(request.getParameter("employeeId") !=null){
				employeeId = Integer.parseInt(request.getParameter("employeeId"));
			}else{
				employeeId =  new EmployeeServiceImpl().getEmployeeInfoByLoginName(name).getId();
			}
			List<Workpoint> list = workPointService.queryWorkPointInfoByEmployeeId(employeeId);
			request.setAttribute("list", list);
			request.getRequestDispatcher("jsp/workpoint/workpointrecord_employeelist.jsp")
					.forward(request, response);
		}
	}
}
