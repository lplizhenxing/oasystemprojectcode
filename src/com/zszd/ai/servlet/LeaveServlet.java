package com.zszd.ai.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zszd.ai.pojo.Leave;
import com.zszd.ai.service.leave.LeaveService;
import com.zszd.ai.service.leave.LeaveServiceImpl;
import com.zszd.ai.tools.LeaveState;

/**
 * 
 * @ClassName:       LeaveServlet
 * @Description:    请假条管理
 * @author:            lizx
 * @date:            2018-1-21        上午12:38:56
 */
@WebServlet(urlPatterns = { "/leave" }, name = "leave")
public class LeaveServlet extends HttpServlet {

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
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + path + "/";
		
		HttpSession session = request.getSession();// 获取session
		String name = (String) session.getAttribute("login");
		int roleId = (Integer) session.getAttribute("roleId");
		int companyId = (Integer) session.getAttribute("companyId");

		PrintWriter out = response.getWriter();
		LeaveService leaveService = new LeaveServiceImpl();
		String opr = request.getParameter("opr");
		if ("personlist".equals(opr)) {
			List<Leave> list = leaveService.queryAllLeaveInfoByName(name);
			request.setAttribute("list", list);
			request.getRequestDispatcher("jsp/leave/leave_personlist.jsp").forward(
					request, response);
		}else if ("list".equals(opr)) {
			List<Leave> list = leaveService.queryAllLeaveInfo();
			if (roleId == 6) {
				list = leaveService.queryAllLeaveInfoByCompanyIdAndName(companyId,name);
			}else if (roleId == 4 || roleId == 5) {
				list = leaveService.queryAllLeaveInfoByCompanyId(companyId);
			} else {
				list = leaveService.queryAllLeaveInfo();
			}
			request.setAttribute("list", list);
			request.getRequestDispatcher("jsp/leave/leave_list.jsp").forward(
					request, response);
		} else if ("add".equals(opr)) {
			String leaveReason = request.getParameter("leaveReason");
			Leave leave = new Leave();
			leave.setUserName(name);
			leave.setLeaveReason(leaveReason);
			
			int row = leaveService.addLeaveInfo(leave);
			if (row > 0) {
				out.print("<script type='text/javascript'>");
				out.print("alert('请假条提交成功，等待审批，点击确认回到请假条页面！');");
				out.print("location.href=\"" + basePath + "leave?opr=personlist\";");
				out.print("</script>");
			} else {
				out.print("<script type='text/javascript'>");
				out.print("alert('请假条已提交，请查看已提交的请假条！');");
				out.print("location.href=\"" + basePath
						+ "leave?opr=personlist\";");
				out.print("</script>");
			}
		} 
	}
}
