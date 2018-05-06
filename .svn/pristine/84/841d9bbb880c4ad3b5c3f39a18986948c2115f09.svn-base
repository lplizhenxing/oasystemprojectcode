package com.zszd.ai.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zszd.ai.pojo.Classes;
import com.zszd.ai.pojo.Employee;
import com.zszd.ai.service.classes.ClassesService;
import com.zszd.ai.service.classes.ClassesServiceImpl;
import com.zszd.ai.tools.Constants;
import com.zszd.ai.tools.PageSupport;

@Controller
@RequestMapping("/sys/classes")
public class ClassesController {
	private Logger logger = Logger.getLogger(ClassesController.class);

	@Resource
	ClassesService classesService = new ClassesServiceImpl();

	// 实现跳转到添加班级页
	@RequestMapping(value = "/addClasses.html")
	public String addClasses() {
		return "classes/classes_add";
	}

	// ajax获取班级信息
	@RequestMapping(value = "/queryAllClasses.html", method = RequestMethod.GET)
	@ResponseBody
	public List<Classes> queryAllClasses(HttpSession session) {
		int roleId = ((Employee) session
				.getAttribute(Constants.EMPlOYEE_SESSION)).getRoleId();
		String name = ((Employee) session
				.getAttribute(Constants.EMPlOYEE_SESSION)).getName();
		List<Classes> cList = null;
		if (roleId == Constants.MANAGER) {
			cList = classesService.queryAllClasses();
		}else if(roleId == Constants.CLASSLEADER) {
			cList = classesService.queryAllClassesByClassLeader(name);
		}
		return cList;
	}

	@RequestMapping(value = "view.html")
	public String view(Model model,
			@RequestParam(value = "queryClassName", required = false) String queryClassName,
			@RequestParam(value = "queryClassLeader", required = false) String queryClassLeader,
			@RequestParam(value = "queryClassTeacher", required = false) String queryClassTeacher,
			@RequestParam(value = "pageIndex", required = false) String pageIndex) {
//		List<Classes> list = classesService.queryAllClasses();
//		request.setAttribute("list", list);
//		return "classes/classes_list";
		
		logger.info("getUserList ---- > queryClassName: "
				+ queryClassName);
		logger.info("getUserList ---- > queryClassLeader: " + queryClassLeader);
		logger.info("getUserList ---- > queryClassTeacher: " + queryClassTeacher);
		logger.info("getUserList ---- > pageIndex: " + pageIndex);

		List<Classes> clasesList = null;
		// 设置页面容量
		int pageSize = Constants.pageSize;
		// 当前页码
		int currentPageNo = 1;

		if (queryClassName == null) {
			queryClassName = "";
		}
		
		if (queryClassLeader == null) {
			queryClassLeader = "";
		}
	
		if (queryClassTeacher == null) {
			queryClassTeacher = "";
		}
	
		if (pageIndex != null) {
			try {
				currentPageNo = Integer.valueOf(pageIndex);
			} catch (NumberFormatException e) {
				return "redirect:/user/syserror.html";
			}
		}
		// 总数量（表）
		int totalCount = classesService.getClassesCount(
				queryClassName, queryClassLeader,queryClassTeacher);
		// 总页数
		PageSupport pages = new PageSupport();
		pages.setCurrentPageNo(currentPageNo);
		pages.setPageSize(pageSize);
		pages.setTotalCount(totalCount);
		int totalPageCount = pages.getTotalPageCount();
		// 控制首页和尾页
		if (currentPageNo < 1) {
			currentPageNo = 1;
		} else if (currentPageNo > totalPageCount) {
			currentPageNo = totalPageCount;
		}
		int currentPage = pageSize*(currentPageNo-1);
		clasesList = classesService.getClassesListBy(
				queryClassName, queryClassLeader, queryClassTeacher,currentPage, pageSize);
		model.addAttribute("list", clasesList);
		model.addAttribute("queryClassName", queryClassName);
		model.addAttribute("queryClassLeader", queryClassLeader);
		model.addAttribute("queryClassTeacher", queryClassTeacher);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPageNo", currentPageNo);
		return "classes/classes_list";
	}

	@RequestMapping(value = "toaddClasses.html")
	public String toaddClasses(HttpServletRequest request) {
		String className = request.getParameter("className");
		String classLeader = request.getParameter("classLeader");
		String classTeacher = request.getParameter("classTeacher");
		Classes classes = new Classes();
		classes.setClassName(className);
		classes.setClassLeader(classLeader);
		classes.setClassTeacher(classTeacher);
		int row = classesService.insertClasses(classes);
		if (row > 0) {
			return "redirect:/sys/classes/view.html";
		} else {
			request.setAttribute("error", "添加失败");
			return "redirect:/sys/classes/view.html";
		}

	}

	@RequestMapping(value = "deleteclasses.html")
	public String deleteclasses(HttpServletRequest request) {
		int classId = Integer.parseInt(request.getParameter("id"));
		int row = classesService.deleteClassByClassId(classId);
		if (row > 0) {
			return "redirect:/sys/classes/view.html";
		} else {
			request.setAttribute("error", "添加失败");
			return "redirect:/sys/classes/view.html";
		}
	}

	// 实现跳转到班级修改页
	@RequestMapping(value = "/modifyclasses.html")
	public String modifyclasses(HttpServletRequest request) {
		int classId = Integer.parseInt(request.getParameter("id"));
		Classes classes = classesService.queryClassByClassId(classId);
		request.setAttribute("classes", classes);
		return "/classes/classes_modify";
	}

	// 修改班级
	@RequestMapping(value = "/tomodifyclasses.html")
	public String tomodifyclasses(HttpServletRequest request) {
		int classId = Integer.parseInt(request.getParameter("classId"));
		String className = request.getParameter("className");
		String classLeader = request.getParameter("classLeader");
		String classTeacher = request.getParameter("classTeacher");
		Classes classes = new Classes();
		classes.setId(classId);
		classes.setClassName(className);
		classes.setClassLeader(classLeader);
		classes.setClassTeacher(classTeacher);
		int row = classesService.updateClassesById(classes);
		if (row > 0) {
			return "redirect:/sys/classes/view.html";
		} else {
			request.setAttribute("error", "修改失败");
			return "redirect:/sys/classes/view.html";
		}
	}

}
