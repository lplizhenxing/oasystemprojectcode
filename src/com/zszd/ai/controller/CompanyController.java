package com.zszd.ai.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zszd.ai.pojo.Company;
import com.zszd.ai.service.company.CompanyService;
import com.zszd.ai.service.company.CompanyServiceImpl;
import com.zszd.ai.tools.Constants;
import com.zszd.ai.tools.PageSupport;

@Controller
@RequestMapping("/sys/company")
public class CompanyController {
	private Logger logger = Logger.getLogger(CompanyController.class);

	@Resource
	CompanyService companyService = new CompanyServiceImpl();

	// 实现跳转到添加公司页
	@RequestMapping(value = "/addCompany.html")
	public String addCompany() {
		return "/company/company_add";
	}

	@RequestMapping(value = "view.html")
	public String view(Model model,@RequestParam(value = "queryCompanyName", required = false) String queryCompanyName,
			@RequestParam(value = "queryClassName", required = false) String queryClassName,
			@RequestParam(value = "pageIndex", required = false) String pageIndex) {
		logger.info("getUserList ---- > queryCompanyName: "
				+ queryCompanyName);
		logger.info("getUserList ---- > queryClassName: " + queryClassName);
		logger.info("getUserList ---- > pageIndex: " + pageIndex);

		List<Company> companies = null;
		// 设置页面容量
		int pageSize = Constants.pageSize;
		// 当前页码
		int currentPageNo = 1;

		if (queryClassName == null) {
			queryClassName = "";
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
		int totalCount = companyService.getCompanyCount(
				queryClassName, queryCompanyName);
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
		companies = companyService.getCompanyListBy(
				queryClassName, queryCompanyName,currentPage, pageSize);
		model.addAttribute("list", companies);
		model.addAttribute("queryClassName", queryClassName);
		model.addAttribute("queryCompanyName", queryCompanyName);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPageNo", currentPageNo);
		return "company/company_list";
	}
	
	@RequestMapping(value = "viewcompany.html")
	public String viewcompany(HttpServletRequest request) {
		int companyId = Integer.parseInt(request.getParameter("id"));
		Company company = companyService.queryCompanyById(companyId);
		request.setAttribute("company", company);
		return "company/companyView_list";
	}

	@RequestMapping(value = "toaddCompany.html")
	public String toaddCompany(HttpServletRequest request) {
		String comname = request.getParameter("comname");
		String url = request.getParameter("url");
		String tel = request.getParameter("tel");
		String fax = request.getParameter("fax");
		String buildTime = request.getParameter("buildTime");
		String province = request.getParameter("s_province");
		String city = request.getParameter("s_city");
		String county = request.getParameter("s_county");
		String detail = request.getParameter("detail");
		String address = province + city + county + detail;
		int classId = Integer.parseInt(request.getParameter("classId"));
		Company company = new Company();
		company.setName(comname);
		company.setUrl(url);
		company.setTelephone(tel);
		company.setFax(fax);
		company.setBuildTime(buildTime);
		company.setAddress(address);
		company.setClassId(classId);
		int row = companyService.insertCompany(company);
		if (row > 0) {
			return "redirect:/sys/company/view.html";
		} else {
			request.setAttribute("error", "添加失败");
			return "company/company_add";
		}
	}


	// 删除公司
	@RequestMapping(value = "/deletecompany.html")
	public String deletecompany(HttpServletRequest request) {
		int companyId = Integer.parseInt(request.getParameter("id"));
		int rows = companyService.deleteCompanyById(companyId);
		if (rows > 0) {
			return "redirect:/sys/company/view.html";
		} else {
			request.setAttribute("error", "删除失败，请联系管理员");
			return "redirect:/sys/company/view.html";
		}
	}

	// 实现跳转到功能修改页
	@RequestMapping(value = "/modifycompany.html")
	public String modifycompany(HttpServletRequest request) {
		int companyId = Integer.parseInt(request.getParameter("id"));
		Company company = companyService.queryCompanyById(companyId);
		request.setAttribute("company", company);
		return "/company/company_modify";
	}

	// 修改功能
	@RequestMapping(value = "/tomodifycompany.html")
	public String tomodifycompany(HttpServletRequest request) {
		String companyId = request.getParameter("companyId");
		String name = request.getParameter("companyName");
		String url = request.getParameter("companyUrl");
		String tel = request.getParameter("companyTel");
		String fax = request.getParameter("companyFax");
		String province = request.getParameter("s_province");
		String city = request.getParameter("s_city");
		String county = request.getParameter("s_county");
		String detail = request.getParameter("detail");
		String address = province+city+county+detail;
		int classId = Integer.parseInt(request.getParameter("classId"));
		Company company = companyService.queryCompanyById(Integer
				.parseInt(companyId));
		company.setName(name);
		company.setTelephone(tel);
		company.setFax(fax);
		company.setClassId(classId);
		company.setUrl(url);
		company.setAddress(address);
		int row = companyService.updateCompany(company);
		if (row > 0) {
			return "redirect:/sys/company/view.html";
		} else {
			request.setAttribute("error", "修改失败，请联系管理员");
			return "redirect:/sys/company/modifycompany.html";
		}
	}

}
