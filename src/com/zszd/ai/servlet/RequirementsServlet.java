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

import com.zszd.ai.pojo.Requirements;
import com.zszd.ai.service.requirements.RequirementsService;
import com.zszd.ai.service.requirements.RequirementsServiceImpl;
/**
 * 需求管理
 * @author lizx 20180103
 *
 */
@WebServlet(urlPatterns = { "/requirements" }, name = "RequirementsServlet")
public class RequirementsServlet extends HttpServlet {

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
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();// 获取session
		String name = (String) session.getAttribute("login");
		int roleId = (Integer) session.getAttribute("roleId");
		int companyId = (Integer) session.getAttribute("companyId");

	    RequirementsService requirementsService = new RequirementsServiceImpl();
		String opr = request.getParameter("opr");
	    if ("list".equals(opr)) {
			List<Requirements> list = null;
			if (roleId == 6) {
				list = requirementsService.queryAllRequirementInfoByCompanyIdAndName(companyId,name);
			}else if (roleId == 4 || roleId == 5) {
				list = requirementsService.queryAllRequirementInfoByCompanyId(companyId);
			} else {
				list = requirementsService.queryAllRequirementInfo();
			}
			request.setAttribute("list", list);
			request.getRequestDispatcher("jsp/requirements/requirements_list.jsp").forward(
			request, response); 
		} else if ("add".equals(opr)) {
			String title = request.getParameter("requirementsTitle");
			String content = request.getParameter("requirementsContent");
			Requirements requirements = new Requirements();
			requirements.setUserName(name);
			requirements.setTitle(title);
			requirements.setContent(content);
			
			int row = requirementsService.addRequirementsInfo(requirements);
			if (row > 0) {
				out.print("<script type='text/javascript'>");
				out.print("alert('需求提交成功，点击确认回到需求页面！');");
				out.print("location.href=\"" + basePath + "requirements?opr=list\";");
				out.print("</script>");
			} else {
				out.print("<script type='text/javascript'>");
				out.print("alert('需求提交失败，请重新添加！');");
				out.print("location.href=\"" + basePath
						+ "jsp/requirements/requirements_add.jsp\";");
				out.print("</script>");
			}
		} else if ("modify".equals(opr)) {
			String id = request.getParameter("id");
			Requirements requirements = requirementsService.getRequirementsById(Integer
					.valueOf(id));
			request.setAttribute("requirements", requirements);
			request.getRequestDispatcher("jsp/requirements/requirements_modify.jsp").forward(
					request, response);
		} else if ("submitModify".equals(opr)) {
			String title = request.getParameter("requirementsTitle");
			String content = request.getParameter("requirementsContent");
			String id = request.getParameter("id");
			Requirements requirements = new Requirements();
			requirements.setId(Integer.valueOf(id));
			requirements.setTitle(title);
			requirements.setContent(content);
			int row = requirementsService.updateRequirementsInfo(requirements);
			if (row > 0) {
				out.print("<script type='text/javascript'>");
				out.print("alert('需求信息更新成功，点击确认返回需求信息列表！');");
				out.print("location.href=\"" + basePath + "requirements?opr=list\";");
				out.print("</script>");
			} else {
				out.print("<script type='text/javascript'>");
				out.print("alert('需求信息更新失败，点击确认返回需求信息列表！');");
				out.print("location.href=\"" + basePath + "requirements?opr=list\";");
				out.print("</script>");
			}
		}else if("submitCheck".equals(opr)){
		
			String idStr = request.getParameter("id");
			String requirementsTitle=request.getParameter("requirementsTitle");
			String requirementsContent=request.getParameter("requirementsContent");
			String resolveDevName=request.getParameter("resolveDevName");
			Requirements requirements = new Requirements();
			requirements.setId(Integer.valueOf(idStr));
			requirements.setState("开发中");
			requirements.setResolveDevName(resolveDevName);
			requirements.setTitle(requirementsTitle);
			requirements.setContent(requirementsContent);
			
			int row = requirementsService.updateRequirementsInfo(requirements);
			if (row > 0) {
				out.print("<script type='text/javascript'>");
				out.print("alert('状态更新成功，点击确认返回需求信息列表！');");
				out.print("location.href=\"" + basePath + "requirements?opr=list\";");
				out.print("</script>");
			} else {
				out.print("<script type='text/javascript'>");
				out.print("alert('状态更新失败，点击确认返回需求信息列表！');");
				out.print("location.href=\"" + basePath + "requirements?opr=list\";");
				out.print("</script>");
			}
			
		}else if("check".equals(opr)){
			String id = request.getParameter("id");
			Requirements requirements = requirementsService.getRequirementsById(Integer
					.valueOf(id));
			request.setAttribute("requirements", requirements);
			request.getRequestDispatcher("jsp/requirements/requirements_check.jsp").forward(
					request, response);
			
			
		} 
	}
}
