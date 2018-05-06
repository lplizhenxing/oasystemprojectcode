package com.zszd.ai.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zszd.ai.pojo.Devgroup;
import com.zszd.ai.service.devgroup.DevgroupService;
import com.zszd.ai.service.devgroup.DevgroupServiceImpl;
import com.zszd.ai.tools.Constants;
import com.zszd.ai.tools.PageSupport;

@Controller
@RequestMapping("/sys/devgroup")
public class DevgroupController {
	private Logger logger = Logger.getLogger(DevgroupController.class);

	@Resource
	DevgroupService devgroupService = new DevgroupServiceImpl();
	
	
	// 实现跳转到添加公司页
	@RequestMapping(value = "/addDevgroup.html")
	public String addDevgroup() {
		return "/devgroup/devgroup_add";
	}
	
	@RequestMapping(value="view.html")
	public String view(Model model,
			@RequestParam(value = "queryDevgroupName", required = false) String queryDevgroupName,
			@RequestParam(value = "queryDepartmentName", required = false) String queryDepartmentName,
			@RequestParam(value = "queryCompanyName", required = false) String queryCompanyName,
			@RequestParam(value = "pageIndex", required = false) String pageIndex) {
		logger.info("getUserList ---- > queryDevgroupName: "
				+ queryDevgroupName);
		logger.info("getUserList ---- > queryCompanyName: "
				+ queryCompanyName);
		logger.info("getUserList ---- > queryDepartmentName: " + queryDepartmentName);
		logger.info("getUserList ---- > pageIndex: " + pageIndex);

		List<Devgroup> devgroups = null;
		// 设置页面容量
		int pageSize = Constants.pageSize;
		// 当前页码
		int currentPageNo = 1;

		if (queryDevgroupName == null) {
			queryDevgroupName = "";
		}
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
		int totalCount = devgroupService.getDevgroupCount(
				queryDepartmentName, queryCompanyName,queryDevgroupName);
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
		devgroups = devgroupService.getDevgroupListBy(
				queryDepartmentName, queryCompanyName,queryDevgroupName,currentPage, pageSize);
		model.addAttribute("list", devgroups);
		model.addAttribute("queryDevgroupName", queryDevgroupName);
		model.addAttribute("queryDepartmentName", queryDepartmentName);
		model.addAttribute("queryCompanyName", queryCompanyName);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPageNo", currentPageNo);
		return "devgroup/devgroup_list";
	}
	
	@RequestMapping(value="toaddDevgroup.html")
	public String toaddDevgroup(HttpServletRequest request){
		return null;

	}
	
	
	@RequestMapping(value="deleteDevgroup.html")
	public String deleteDevgroup(HttpServletRequest request){	
		return "devgroup/devgroup_list";
	}
	
}
