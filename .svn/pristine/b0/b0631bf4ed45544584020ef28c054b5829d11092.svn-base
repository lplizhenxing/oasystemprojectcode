package com.zszd.ai.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zszd.ai.pojo.Employee;
import com.zszd.ai.pojo.Requirements;
import com.zszd.ai.service.requirements.RequirementsService;
import com.zszd.ai.service.requirements.RequirementsServiceImpl;
import com.zszd.ai.tools.Constants;

@Controller
@RequestMapping("/sys/requirements")
public class RequirementsController {
	private Logger logger = Logger.getLogger(RequirementsController.class);

	@Resource
	RequirementsService requirementsService = new RequirementsServiceImpl();

	// 实现跳转到添加公司页
	@RequestMapping(value = "/addRequirements.html")
	public String addRequirements() {
		return "requirements/requirements_add";
	}

	@RequestMapping(value = "/view.html")
	public String view(HttpServletRequest request, HttpSession session) {
		int roleId = ((Employee) session
				.getAttribute(Constants.EMPlOYEE_SESSION)).getRoleId();
		String name = ((Employee) session
				.getAttribute(Constants.EMPlOYEE_SESSION)).getName();
		int companyId = ((Employee) session
				.getAttribute(Constants.EMPlOYEE_SESSION)).getCompanyId();
		List<Requirements> list = null;
		if (roleId == Constants.NORMALSTAFF) {
			list = requirementsService
					.queryAllRequirementInfoByCompanyIdAndName(companyId, name);
		} else if (roleId == Constants.PRESIDENT || roleId == Constants.DIRETOR) {
			list = requirementsService
					.queryAllRequirementInfoByCompanyId(companyId);
		} else {
			list = requirementsService.queryAllRequirementInfo();
		}
		request.setAttribute("list", list);
		return "requirements/requirements_list";
	}

	@RequestMapping(value = "toaddRequirements.html")
	public String toaddRequirements(HttpServletRequest request,
			HttpSession session) {
		String name = ((Employee) session
				.getAttribute(Constants.EMPlOYEE_SESSION)).getName();
		String title = request.getParameter("requirementsTitle");
		String content = request.getParameter("requirementsContent");
		Requirements requirements = new Requirements();
		requirements.setUserName(name);
		requirements.setTitle(title);
		requirements.setContent(content);

		int row = requirementsService.addRequirementsInfo(requirements);
		if (row > 0) {
			return "redirect:/sys/requirements/view.html";
		} else {
			request.setAttribute("error", "添加失败");
			return "redirect:/sys/requirements/view.html";
		}
	}

	// 实现跳转到操作页
	@RequestMapping(value = "/oprRequirements.html")
	public String oprRequirements(HttpServletRequest request, HttpSession session) {
		String opr = request.getParameter("opr");
		int requirementsId = Integer.parseInt(request.getParameter("id"));
		Requirements requirements = requirementsService.getRequirementsById(requirementsId);
		request.setAttribute("requirements", requirements);
		switch (opr) {
		case Constants.MODIFY:
			return "requirements/requirements_modify";
		case Constants.CHECK:
			return "requirements/requirements_check";
		case Constants.TOMODIFY:
			String title = request.getParameter("requirementsTitle");
			String content = request.getParameter("requirementsContent");
			requirements.setTitle(title);
			requirements.setContent(content);
			int row = requirementsService.updateRequirementsInfo(requirements);
			if (row > 0) {
				return "redirect:/sys/requirements/view.html";
			} else {
				request.setAttribute("error", "操作失败");
				return "redirect:/sys/requirements/view.html";
			}
		case Constants.TOCHECK:
			String title2 = request.getParameter("requirementsTitle");
			String content2 = request.getParameter("requirementsContent");
			String resolveDevName = request.getParameter("resolveDevName");
			requirements.setState("开发中");
			requirements.setResolveDevName(resolveDevName);
			requirements.setTitle(title2);
			requirements.setContent(content2);
			int row2 = requirementsService.updateRequirementsInfo(requirements);
			if (row2 > 0) {
				return "redirect:/sys/requirements/view.html";
			} else {
				request.setAttribute("error", "操作失败");
				return "redirect:/sys/requirements/view.html";
			}
		}
		return null;
	}

}
