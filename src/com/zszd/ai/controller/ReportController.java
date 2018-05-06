package com.zszd.ai.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zszd.ai.pojo.Employee;
import com.zszd.ai.pojo.Report;
import com.zszd.ai.pojo.ReportType;
import com.zszd.ai.pojo.Role;
import com.zszd.ai.service.report.ReportService;
import com.zszd.ai.service.report.ReportServiceImpl;
import com.zszd.ai.tools.Constants;
import com.zszd.ai.tools.PageSupport;

@Controller
@RequestMapping("/sys/report")
public class ReportController {
	private Logger logger = Logger.getLogger(ReportController.class);

	@Resource
	ReportService reportService = new ReportServiceImpl();

	@RequestMapping(value = "view.html")
	public String view(HttpServletRequest request, HttpSession session) {
		int roleId = ((Employee) session
				.getAttribute(Constants.EMPlOYEE_SESSION)).getRoleId();
		String name = ((Employee) session
				.getAttribute(Constants.EMPlOYEE_SESSION)).getName();
		int companyId = ((Employee) session
				.getAttribute(Constants.EMPlOYEE_SESSION)).getCompanyId();
		List<Report> list = null;
		if (roleId == Constants.NORMALSTAFF) {
			list = reportService.getUserbyuserName(name);
		} else if (roleId == Constants.PRESIDENT || roleId == Constants.DIRETOR) {
			list = reportService.getAllReportListByCompanyId(companyId);
		} else {
			list = reportService.getAllReportList();
		}
		request.setAttribute("list", list);
		return "report/report_list";
	}

	
	@RequestMapping(value = "/reportviewBy.html")
	public String reportviewBy(
			Model model,
			@RequestParam(value = "queryEmployeeName", required = false) String queryEmployeeName,
			@RequestParam(value = "queryReporttype", required = false) String queryReporttype,
			@RequestParam(value = "createDate", required = false) String createDate,
			@RequestParam(value = "pageIndex", required = false) String pageIndex,
			HttpSession session) {

		int _queryUserRole = 0;

		List<Report> list = null;
		// 设置页面容量
		int pageSize = Constants.pageSize;
		// 当前页码
		int currentPageNo = 1;

		if (queryEmployeeName == null) {
			queryEmployeeName = "";
		}

		if (queryReporttype == null) {
			queryReporttype = "";
		}

		if (createDate == null) {
			createDate = "";
		}

		if (pageIndex != null) {
			try {
				currentPageNo = Integer.valueOf(pageIndex);
			} catch (NumberFormatException e) {
				return "redirect:/user/syserror.html";
			}
		}
		// 总数量（表）
		int totalCount = 0;

		int roleId = ((Employee) session
				.getAttribute(Constants.EMPlOYEE_SESSION)).getRoleId();
		String name = ((Employee) session
				.getAttribute(Constants.EMPlOYEE_SESSION)).getName();
		int companyId = ((Employee) session
				.getAttribute(Constants.EMPlOYEE_SESSION)).getCompanyId();
		
		if (roleId == Constants.NORMALSTAFF) {
			totalCount = reportService.getAllReportCountByUserNameBy(queryEmployeeName,queryReporttype,createDate,name);
		} else if (roleId == Constants.PRESIDENT || roleId == Constants.DIRETOR) {
			totalCount = reportService.getAllReportCountByCompanyIdBy(queryEmployeeName,queryReporttype,createDate,companyId);
		} else {
			totalCount = reportService.getAllReportCountBy(queryEmployeeName,queryReporttype,createDate);
		}


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
		int currentPage = pageSize * (currentPageNo - 1);


		if (roleId == Constants.NORMALSTAFF) {
			list = reportService.getAllReportListByUserNameBy(queryEmployeeName,queryReporttype,createDate,name, currentPage, pageSize);
		} else if (roleId == Constants.PRESIDENT || roleId == Constants.DIRETOR) {
			list = reportService.getAllReportListByCompanyIdBy(queryEmployeeName,queryReporttype,createDate,companyId, currentPage, pageSize);
		} else {
			list = reportService.getAllReportListBy(queryEmployeeName,queryReporttype,createDate, currentPage, pageSize);
		}
		

		List<ReportType> typeList = reportService.getAllReportType();
		model.addAttribute("typeList", typeList);
		model.addAttribute("list", list);
		model.addAttribute("queryEmployeeName", queryEmployeeName);
		model.addAttribute("queryReporttype", queryReporttype);
		model.addAttribute("createDate", createDate);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPageNo", currentPageNo);
		return "report/report_list";
	}

	// 实现跳转到添加班级页
	@RequestMapping(value = "/addReport.html")
	public String addReport(HttpServletRequest request) {
		List<ReportType> reportTypelist = reportService.getAllReportType();
		request.setAttribute("reportTypelist", reportTypelist);
		return "report/report_add";
	}

	@RequestMapping(value = "toaddReport.html")
	public String toaddReport(HttpServletRequest request, HttpSession session) {
		String name = ((Employee) session
				.getAttribute(Constants.EMPlOYEE_SESSION)).getName();
		String reporttype = request.getParameter("reporttype");
		ReportType rtype = reportService.gettypeIdByReportTypename(reporttype);
		Integer typeId = rtype.getId();
		String answer = request.getParameter("question");
		String finish = request.getParameter("finishwork");
		String plan = request.getParameter("plan");
		String remark = request.getParameter("remark");
		Report report = new Report();
		report.setTypeId(typeId);
		report.setUsername(name);
		report.setQuestion(answer);
		report.setFinishwork(finish);
		report.setPlan(plan);
		report.setRemark(remark);
		int row = reportService.addReport(report);
		if (row > 0) {
			return "redirect:/sys/report/view.html";
		} else {
			request.setAttribute("error", "添加失败");
			return "redirect:/sys/report/view.html";
		}
	}

	@RequestMapping(value = "/modifyReport.html")
	public String modifyReport(HttpServletRequest request) {
		String reportId = request.getParameter("reportId");
		Report report = reportService.getReportbyId(Integer.valueOf(reportId));
		List<ReportType> reportTypelist = reportService.getAllReportType();
		request.setAttribute("reportTypelist", reportTypelist);
		request.setAttribute("report", report);
		return "report/report_modify";
	}

	@RequestMapping(value = "/tomodifyReport.html")
	public String tomodifyReport(HttpServletRequest request) {
		String reporttype = request.getParameter("reporttype");
		ReportType rtype = reportService.gettypeIdByReportTypename(reporttype);
		Integer typeId = rtype.getId();
		String question = request.getParameter("question");
		String finish = request.getParameter("finishwork");
		String plan = request.getParameter("plan");
		String remark = request.getParameter("remark");
		String reportIdchange = request.getParameter("reportIdchange");

		Report report = new Report();
		report.setId(Integer.valueOf(reportIdchange));
		report.setTypeId(typeId);
		report.setQuestion(question);
		report.setFinishwork(finish);
		report.setPlan(plan);
		report.setRemark(remark);
		int row = reportService.modifyReport(report);
		if (row > 0) {
			return "redirect:/sys/report/view.html";
		} else {
			request.setAttribute("error", "操作失败");
			return "redirect:/sys/report/view.html";
		}
	}

}
