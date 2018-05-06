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
import com.zszd.ai.pojo.SysUser;
import com.zszd.ai.service.employee.EmployeeService;
import com.zszd.ai.service.employee.EmployeeServiceImpl;
import com.zszd.ai.service.sysuser.SysUserService;
import com.zszd.ai.service.sysuser.SysUserServiceImpl;

/**
 * 员工
 * 
 * @author lizx 20180103
 * 
 */
@WebServlet(urlPatterns = { "/employee" }, name = "employee")
public class EmployeeServlet extends HttpServlet {

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
		String opr = request.getParameter("opr");
		String employeeId = request.getParameter("employeeId");
		HttpSession session = request.getSession();// 获取session
		String name = (String) session.getAttribute("login");
		int roleId = (Integer) session.getAttribute("roleId");
		int companyId = (Integer) session.getAttribute("companyId");
		EmployeeService employeeService = new EmployeeServiceImpl();
		SysUserService sysUserService = new SysUserServiceImpl();
		PrintWriter out = response.getWriter();
		if ("list".equals(opr)) {
			List<Employee> list = null;
			if (roleId == 4 || roleId == 5 || roleId == 6) {
				list = employeeService.queryAllEmployeeInfoByCompanyId(companyId);
			}else{
				list = employeeService.queryAllEmployeeInfo();
			}
			request.setAttribute("list", list);
			request.getRequestDispatcher("jsp/employee/employee_list.jsp")
					.forward(request, response);
		} else if ("modify".equals(opr)) {
			Employee employee = employeeService.queryEmployeeInfoById(Integer
					.valueOf(employeeId));
			request.setAttribute("employee", employee);
			request.getRequestDispatcher("jsp/employee/employee_modify.jsp")
					.forward(request, response);
		} else if ("submitModify".equals(opr)) {
			String employeename = request.getParameter("employeename");
			String validDocuments = request.getParameter("validDocuments");
			String comId = request.getParameter("companyId");
			String workpoints = request.getParameter("workpoints");
			String id = request.getParameter("employeeId");
			Employee employee = employeeService.queryEmployeeInfoById(Integer
					.valueOf(id));
			employee.setId(Integer.valueOf(id));
			employee.setName(employeename);
			employee.setValidDocuments(validDocuments);
			employee.setCompanyId(Integer.valueOf(comId));
			employee.setWorkpoints(Integer.valueOf(workpoints));
			int row = employeeService.updateEmployeeInfo(employee);
			if (row > 0) {
				out.print("<script type='text/javascript'>");
				out.print("alert('更新成功，点击确认返回员工列表！');");
				out.print("location.href=\"" + basePath
						+ "employee?opr=list\";");
				out.print("</script>");
			} else {
				out.print("<script type='text/javascript'>");
				out.print("alert('更新失败，点击确认返回员工列表！');");
				out.print("location.href=\"" + basePath
						+ "employee?opr=list\";");
				out.print("</script>");
			}
		} else if ("query".equals(opr)) {
			int workpoint = employeeService.queryWorkPointByAbbr(name);
			if (workpoint >= 200) {// 大于200分 可以参与工时抽奖
				out.print("true");
			} else {
				out.print("false");
			}
		} else if ("info".equals(opr)) {
			Employee employee = employeeService
					.getEmployeeInfoByLoginName(name);
			SysUser sUser = sysUserService.getUserInfoByUserName(name);
			request.setAttribute("employee", employee);
			request.setAttribute("sUser", sUser);
			request.getRequestDispatcher("jsp/sysuser/user_info.jsp").forward(
					request, response);
		} else if ("revise".equals(opr)) {
			Employee employee = (Employee) session.getAttribute("employee");
			employee.setWorkType(request.getParameter("workType"));
			employee.setWorkUnit(request.getParameter("workUnit"));
			employee.setWorkState(request.getParameter("workState"));
			employee.setMajor(request.getParameter("major"));
			employee.setEndSchool(request.getParameter("endSchool"));
			employee.setEducation(request.getParameter("education"));
			employee.setEndTime(request.getParameter("endTime"));
			employee.setPostalcode(request.getParameter("postalcode"));
			employee.setPhone(request.getParameter("phone"));
			employee.setAddress(request.getParameter("address"));
			employee.setIntentionalCity(request.getParameter("intentionalCity"));
			employee.setIntentionalPost(request.getParameter("intentionalPost"));
			employee.setEmail(request.getParameter("email"));
			int row = employeeService.updateAllInfo(employee);
			if (row > 0) {
				request.setAttribute("msg", "修改成功");
				session.setAttribute("employee", employee);
			} else {
				request.setAttribute("msg", "修改失败");
			}
			request.getRequestDispatcher("employee?opr=info").forward(request,
					response);
		}
	}
}
