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

import com.zszd.ai.pojo.Devgroup;
import com.zszd.ai.service.devgroup.DevgroupService;
import com.zszd.ai.service.devgroup.DevgroupServiceImpl;
import com.zszd.ai.service.employee.EmployeeService;
import com.zszd.ai.service.employee.EmployeeServiceImpl;

/**
 * 
 * @ClassName       DevgroupServlet
 * @Description    研发组控制器
 * @author            lizx
 * @date           2018-1-30        下午12:06:54
 */
@WebServlet(urlPatterns = { "/devgroup" }, name = "devgroup")
public class DevgroupServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + path + "/";
		
		HttpSession session = request.getSession();// 获取session
		int roleId = (Integer) session.getAttribute("roleId");
		int companyId = (Integer) session.getAttribute("companyId");
		
		DevgroupService devgroupService = new DevgroupServiceImpl();
		String opr = request.getParameter("opr");
		String groupId = request.getParameter("groupId");
		PrintWriter out = response.getWriter();
		if ("list".equals(opr)) {
			List<Devgroup> list = devgroupService.queryAllDevGroupInfo();
			if (roleId == 6) {
				list = null;
			} else if(roleId ==5 || roleId == 4){
				list = devgroupService.queryAllDevGroupInfoByCompanyId(companyId);
			} else{
				list = devgroupService.queryAllDevGroupInfo();
			}
			
			request.setAttribute("list", list);
			request.getRequestDispatcher("jsp/devgroup/devgroup_list.jsp")
					.forward(request, response);
		} else if ("modify".equals(opr)) {
			Devgroup devgroup = devgroupService.queryDevGroupInfoById(Integer
					.valueOf(groupId));
			request.setAttribute("devgroup", devgroup);
			request.getRequestDispatcher("jsp/devgroup/devgroup_modify.jsp")
					.forward(request, response);
		} else if ("submitAdd".equals(opr)) {
			String groupname = request.getParameter("groupname");
			String watch = request.getParameter("watch");
			int departmentId = Integer.parseInt(request.getParameter("deId"));
			Devgroup devgroup = new Devgroup();
			devgroup.setName(groupname);
			devgroup.setWatchword(watch);
			devgroup.setDepartmentId(departmentId);
			int row = devgroupService.insertDevGroup(devgroup);
			if (row > 0) {
				out.print("<script type='text/javascript'>");
				out.print("alert('添加研发组成功');");
				out.print("location.href=\"" + basePath
						+ "devgroup?opr=list\";");
				out.print("</script>");
			} else {
				out.print("<script type='text/javascript'>");
				out.print("alert('添加研发组失败');");
				out.print("location.href=\"" + basePath
						+ "devgroup?opr=list\";");
				out.print("</script>");
			}
		} else if ("delete".equals(opr)) {
			out.print("<script type='text/javascript'>");
			out.print("alert('确认要删除吗？点击确认删除！');");
			out.print("location.href=\"" + basePath
					+ "devgroup?opr=deleteDevGroup&groupId=" + groupId + "\";");
			out.print("</script>");
		} else if ("submitModify".equals(opr)) {
			String groupname = request.getParameter("groupname");
			String watch = request.getParameter("watch");
			String id = request.getParameter("groupId");
			int deId = Integer.parseInt(request.getParameter("deId"));
			Devgroup devgroup = new Devgroup();
			devgroup.setId(Integer.valueOf(id));
			devgroup.setName(groupname);
			devgroup.setWatchword(watch);
			devgroup.setDepartmentId(deId);
			int row = devgroupService.updateDevGroupInfo(devgroup);
			if (row > 0) {
				out.print("<script type='text/javascript'>");
				out.print("alert('当前研发组更新成功，点击确认返回研发组信息列表！');");
				out.print("location.href=\"" + basePath
						+ "devgroup?opr=list\";");
				out.print("</script>");
			} else {
				out.print("<script type='text/javascript'>");
				out.print("alert('当前研发组更新失败，点击确认返回研发组列表！');");
				out.print("location.href=\"" + basePath
						+ "devgroup?opr=list\";");
				out.print("</script>");
			}
		} else if ("deleteDevGroup".equals(opr)) {
			EmployeeService employeeService = new EmployeeServiceImpl();
			if (employeeService.getEmployeeCountByGroupId(Integer
					.valueOf(groupId)) == 0) {
				if (devgroupService
						.deleteDevGroupById(Integer.valueOf(groupId)) > 0) {
					out.print("<script type='text/javascript'>");
					out.print("alert('成功删除该研发组，点击确认返回研发组信息列表！');");
					out.print("location.href=\"" + basePath
							+ "devgroup?opr=list\";");
					out.print("</script>");
				} else {
					out.print("<script type='text/javascript'>");
					out.print("alert('删除研发组失败，请联系管理员！点击确认返回研发组信息列表！');");
					out.print("location.href=\"" + basePath
							+ "devgroup?opr=list\";");
					out.print("</script>");
				}
			} else {
				out.print("<script type='text/javascript'>");
				out.print("alert('该研发组下还有学员，不能删除！');");
				out.print("location.href=\"" + basePath
						+ "devgroup?opr=list\";");
				out.print("</script>");
			}
		}
	}
}
