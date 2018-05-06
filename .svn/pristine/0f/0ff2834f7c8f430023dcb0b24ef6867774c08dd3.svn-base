package com.zszd.ai.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zszd.ai.pojo.Bugs;
import com.zszd.ai.pojo.Employee;
import com.zszd.ai.service.bugs.BugsService;
import com.zszd.ai.service.bugs.BugsServiceImpl;
import com.zszd.ai.tools.Constants;

@Controller
@RequestMapping("/sys/bugs")
public class BugsController {
	private Logger logger = Logger.getLogger(BugsController.class);

	@Resource
	BugsService bugsService = new BugsServiceImpl();
	
	
	// 实现跳转到添加公司页
	@RequestMapping(value = "/addBugs.html")
	public String addBugs() {
		return "bugs/bugs_add";
	}
	
	@RequestMapping(value="/view.html")
	public String view(HttpServletRequest request,HttpSession session){	
		int roleId = ((Employee) session
				.getAttribute(Constants.EMPlOYEE_SESSION)).getRoleId();
		String name = ((Employee) session
				.getAttribute(Constants.EMPlOYEE_SESSION)).getName();
		int companyId = ((Employee) session
				.getAttribute(Constants.EMPlOYEE_SESSION)).getCompanyId();
		List<Bugs> list = null;
		if (roleId == Constants.NORMALSTAFF) {
			list = bugsService.queryAllDebugsInfoByCompanyIdAndName(companyId,
					name);
		} else if (roleId == Constants.PRESIDENT || roleId == Constants.DIRETOR) {
			list = bugsService.queryAllDebugsInfoByCompanyId(companyId);
		} else {
			list = bugsService.queryAllDebugsInfo();
		}
		request.setAttribute("list", list);
		return "bugs/bugs_list";
	}
	
	@RequestMapping(value="toaddBugs.html")
	public String toaddBugs(HttpServletRequest request,HttpSession session){
		String name = ((Employee) session
				.getAttribute(Constants.EMPlOYEE_SESSION)).getName();
		String title = request.getParameter("bugsTitle");
		String content = request.getParameter("bugsContent");
		Bugs bugs = new Bugs();
		bugs.setUserName(name);
		bugs.setTitle(title);
		bugs.setContent(content);

		int row = bugsService.addBugsInfo(bugs);
		if (row > 0) {
			return "redirect:/sys/bugs/view.html";
		} else {
			request.setAttribute("error", "添加失败");
			return "redirect:/sys/bugs/view.html";
		}
	}
	
	// 实现跳转到操作页
	@RequestMapping(value = "/oprBugs.html")
	public String oprBugs(HttpServletRequest request, HttpSession session) {
		String opr = request.getParameter("opr");
		int bugsId = Integer.parseInt(request.getParameter("id"));
		Bugs bugs = bugsService.getBugsById(bugsId);
		request.setAttribute("bugs", bugs);
		switch (opr) {
		case Constants.MODIFY:
			return "bugs/bugs_modify";
		case Constants.CHECK:
			return "bugs/bugs_check";
		case Constants.TOMODIFY:
			String title = request.getParameter("bugsTitle");
			String content = request.getParameter("bugsContent");
			bugs.setTitle(title);
			bugs.setContent(content);
			int row = bugsService.updateBugsInfo(bugs);
			if (row > 0) {
				return "redirect:/sys/bugs/view.html";
			} else {
				request.setAttribute("error", "操作失败");
				return "redirect:/sys/bugs/view.html";
			}
		case Constants.TOCHECK:
			String title2 = request.getParameter("bugsTitle");
			String content2 = request.getParameter("bugsContent");
			String resolveDevName=request.getParameter("resolveDevName");
			bugs.setState("开发中");
			bugs.setResolveDevName(resolveDevName);
			bugs.setTitle(title2);
			bugs.setContent(content2);
			int row2 = bugsService.updateBugsInfo(bugs);
			if (row2 > 0) {
				return "redirect:/sys/bugs/view.html";
			} else {
				request.setAttribute("error", "操作失败");
				return "redirect:/sys/bugs/view.html";
			}
		}
		return null;
	}
}
