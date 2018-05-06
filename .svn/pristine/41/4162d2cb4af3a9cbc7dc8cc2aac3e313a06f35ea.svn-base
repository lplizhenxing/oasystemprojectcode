package com.zszd.ai.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zszd.ai.pojo.Department;
import com.zszd.ai.service.department.DepartmentService;
import com.zszd.ai.service.department.DepartmentServiceImpl;
import com.zszd.ai.tools.Constants;
import com.zszd.ai.tools.PageSupport;

@Controller
@RequestMapping("/sys/department")
public class DepartmentController {
	private Logger logger = Logger.getLogger(DepartmentController.class);

	@Resource
	DepartmentService departmentService = new DepartmentServiceImpl();
	
	
	// 实现跳转到添加公司页
	@RequestMapping(value = "/addDepartment.html")
	public String addDepartment() {
		return "/department/department_add";
	}
	
	//查看所有的部门  经理级别  
	@RequestMapping(value = "view.html")
	public String view(Model model,@RequestParam(value = "queryDepartmentName", required = false) String queryDepartmentName,
			@RequestParam(value = "queryCompanyName", required = false) String queryCompanyName,
			@RequestParam(value = "pageIndex", required = false) String pageIndex) {
		logger.info("getUserList ---- > queryCompanyName: "
				+ queryCompanyName);
		logger.info("getUserList ---- > queryDepartmentName: " + queryDepartmentName);
		logger.info("getUserList ---- > pageIndex: " + pageIndex);

		List<Department> departments = null;
		// 设置页面容量
		int pageSize = Constants.pageSize;
		// 当前页码
		int currentPageNo = 1;

		if (queryDepartmentName == null) {
			queryDepartmentName = "";
		}

		if (queryCompanyName == null) {
			queryCompanyName = "";
		}
	
		if (pageIndex != null) {
			try {
				currentPageNo = Integer.valueOf(pageIndex);
			} catch (NumberFormatException e) {
				return "redirect:/user/syserror.html";
			}
		}
		// 总数量（表）
		int totalCount = departmentService.getDepartmentCount(
				queryDepartmentName, queryCompanyName);
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
		departments = departmentService.getDepartmentListBy(
				queryDepartmentName, queryCompanyName,currentPage, pageSize);
		model.addAttribute("list", departments);
		model.addAttribute("queryDepartmentName", queryDepartmentName);
		model.addAttribute("queryCompanyName", queryCompanyName);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPageNo", currentPageNo);
		return "department/department_list";
	}
	
	@RequestMapping(value="toaddDepartment.html")
	public String toaddDepartment(HttpServletRequest request){
		return null;
	}
	
	
	@RequestMapping(value="deleteDepartment.html")
	public String deleteDepartment(HttpServletRequest request){	
		return "department/department_list";
	}
	
}
