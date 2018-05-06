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

import com.zszd.ai.pojo.Employee;
import com.zszd.ai.pojo.FunctionRole;
import com.zszd.ai.pojo.Functions;
import com.zszd.ai.pojo.Role;
import com.zszd.ai.service.sysfunctions.FunctionRoleService;
import com.zszd.ai.service.sysfunctions.FunctionRoleServiceImpl;
import com.zszd.ai.service.sysfunctions.FunctionsService;
import com.zszd.ai.service.sysfunctions.FunctionsServiceImpl;
import com.zszd.ai.service.sysfunctions.RoleService;
import com.zszd.ai.service.sysfunctions.RoleServiceImpl;
import com.zszd.ai.tools.Constants;
import com.zszd.ai.tools.PageSupport;

@Controller
@RequestMapping("/sys/functionRole")
public class FunctionRoleController {

	private Logger logger = Logger.getLogger(FunctionRoleController.class);

	@Resource
	FunctionRoleService functionRoleService = new FunctionRoleServiceImpl();
	@Resource
	RoleService roleService = new RoleServiceImpl();
	@Resource
	FunctionsService functionsService = new FunctionsServiceImpl();

	// 实现跳转到功能角色配置页
	@RequestMapping(value = "/addfunctionrole.html")
	public String addfunctionrole() {
		return "/functionRole/functionRole_add";
	}

	// 添加功能角色配置
	@RequestMapping(value = "/toaddfunctionrole.html")
	public String toaddfunctionrole(HttpServletRequest request) {
		int roleId = Integer.parseInt(request.getParameter("roleId"));
		int functionId = Integer.parseInt(request.getParameter("functionId"));
		FunctionRole functionRole = new FunctionRole();
		functionRole.setRoleId(roleId);
		functionRole.setFunctionId(functionId);
		int rows = functionRoleService.addFunctionRoleInfo(functionRole);
		if (rows > 0) {
			return "redirect:/sys/functionRole/queryAllFunctionRoleInfoBy.html";
		} else {
			request.setAttribute("error", "添加失败，请联系管理员");
			return "redirect:/sys/functionRole/addfunctionrole.html";
		}
	}

	// 实现跳转到添加功能
	@RequestMapping(value = "/addfunction.html")
	public String addfunction() {
		return "/functionRole/functions_add";
	}

	// 添加功能
	@RequestMapping(value = "/toaddfunction.html")
	public String toaddfunction(HttpServletRequest request) {
		String functionsName = request.getParameter("functionsName");
		String functionsPath = request.getParameter("functionsPath");
		String dev = request.getParameter("dev");
		Functions functions = new Functions();
		functions.setFunctionName(functionsName);
		functions.setFunctionPath(functionsPath);
		functions.setDev(dev);
		int rows = functionsService.addFunctionsInfo(functions);
		if (rows > 0) {
			return "redirect:/sys/functionRole/queryAllFunctionsInfo.html";
		} else {
			request.setAttribute("error", "添加失败，请联系管理员");
			return "redirect:/sys/functionRole/addfunction.html";
		}
	}

	// 实现跳转到添加角色 暂不实现
	@RequestMapping(value = "/addRole.html")
	public String addRole() {
		return null;
	}

	// 查看所有的功能角色配置
	@RequestMapping(value = "/queryAllFunctionRoleInfoBy.html")
	public String queryAllFunctionRoleInfoBy(
			Model model,
			@RequestParam(value = "queryFunctionName", required = false) String queryFunctionName,
			@RequestParam(value = "queryUserRole", required = false) String queryUserRole,
			@RequestParam(value = "pageIndex", required = false) String pageIndex) {

		logger.info("getUserList ---- > queryFunctionName: "
				+ queryFunctionName);
		logger.info("getUserList ---- > queryUserRole: " + queryUserRole);
		logger.info("getUserList ---- > pageIndex: " + pageIndex);
		int _queryUserRole = 0;

		List<FunctionRole> funRoleList = null;
		// 设置页面容量
		int pageSize = Constants.pageSize;
		// 当前页码
		int currentPageNo = 1;

		if (queryFunctionName == null) {
			queryFunctionName = "";
		}
		if (queryUserRole != null && !queryUserRole.equals("")) {
			_queryUserRole = Integer.parseInt(queryUserRole);
		}

		if (pageIndex != null) {
			try {
				currentPageNo = Integer.valueOf(pageIndex);
			} catch (NumberFormatException e) {
				return "redirect:/user/syserror.html";
				// response.sendRedirect("syserror.jsp");
			}
		}
		// 总数量（表）
		int totalCount = functionRoleService.getFunctionRoleCount(
				queryFunctionName, _queryUserRole);
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
		funRoleList = functionRoleService.getFunctionRoleListBy(
				queryFunctionName, _queryUserRole, currentPage, pageSize);
		List<Role> roleList = roleService.queryAllRoleInfo();
		model.addAttribute("roleList", roleList);
		model.addAttribute("list", funRoleList);
		model.addAttribute("queryFunctionName", queryFunctionName);
		model.addAttribute("queryUserRole", queryUserRole);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPageNo", currentPageNo);
		return "functionRole/functionRole_list";
	}

	// 查看所有的功能角色配置
	@RequestMapping(value = "/queryAllFunctionRoleInfo.html")
	public String queryAllFunctionRoleInfo(HttpServletRequest request) {
		List<FunctionRole> funList = functionRoleService
				.queryAllFunctionRoleInfo();
		request.setAttribute("list", funList);
		return "functionRole/functionRole_list";
	}

	// 查看所有的功能
	@RequestMapping(value = "/queryAllFunctionsInfo.html")
	public String queryAllFunctionsInfo(HttpServletRequest request) {
		List<Functions> funList = functionsService.queryAllFunctionsInfo();
		request.setAttribute("list", funList);
		return "functionRole/functions_list";
	}

	// 查看所有的角色
	@RequestMapping(value = "/queryAllRolesInfo.html")
	public String queryAllRolesInfo(HttpServletRequest request) {
		List<Role> funList = roleService.queryAllRoleInfo();
		request.setAttribute("list", funList);
		return "functionRole/roles_list";
	}

	// 删除功能角色配置
	@RequestMapping(value = "/delfunctionrole.html")
	public String delfunctionrole(HttpServletRequest request) {
		int functionRoleId = Integer.parseInt(request.getParameter("id"));
		int rows = functionRoleService
				.delFunctionRoleConfigInfoById(functionRoleId);
		if (rows > 0) {
			return "redirect:/sys/functionRole/queryAllFunctionRoleInfoBy.html";
		} else {
			request.setAttribute("error", "删除失败，请联系管理员");
			return "redirect:/sys/functionRole/queryAllFunctionRoleInfoBy.html";
		}
	}

	// 删除功能配置
	@RequestMapping(value = "/deletefunction.html")
	public String deletefunction(HttpServletRequest request) {
		int functionId = Integer.parseInt(request.getParameter("id"));
		int rows = functionsService.delFunctionInfoById(functionId);
		if (rows > 0) {
			return "redirect:/sys/functionRole/queryAllFunctionsInfo.html";
		} else {
			request.setAttribute("error", "删除失败，请联系管理员");
			return "redirect:/sys/functionRole/queryAllFunctionsInfo.html";
		}
	}

	// 实现跳转到功能修改页
	@RequestMapping(value = "/modifyfunction.html")
	public String modifyfunction(HttpServletRequest request) {
		int functionId = Integer.parseInt(request.getParameter("id"));
		Functions functions = functionsService
				.queryFunctionsInfoById(functionId);
		request.setAttribute("functions", functions);
		return "functionRole/functions_modify";
	}

	// 修改功能
	@RequestMapping(value = "/tomodifyfunction.html")
	public String tomodifyfunction(HttpServletRequest request) {
		String functionName = request.getParameter("functionName");
		String functionPath = request.getParameter("functionPath");
		String dev = request.getParameter("dev");
		int id = Integer.parseInt(request.getParameter("id"));
		Functions functions = new Functions();
		functions.setId(id);
		functions.setDev(dev);
		functions.setFunctionName(functionName);
		functions.setFunctionPath(functionPath);
		int row = functionsService.updateFunctionsInfo(functions);
		if (row > 0) {
			return "redirect:/sys/functionRole/queryAllFunctionsInfo.html";
		} else {
			request.setAttribute("error", "修改失败，请联系管理员");
			return "redirect:/sys/functionRole/modifyfunction.html";
		}
	}

	// ajax获取 根据角色查看对应的功能
	@RequestMapping(value = "/queryFunctionRoleByRoleId.html", method = RequestMethod.GET)
	@ResponseBody
	public List<FunctionRole> queryFunctionRoleByRoleId(HttpSession session) {
		int roleId = ((Employee) session
				.getAttribute(Constants.EMPlOYEE_SESSION)).getRoleId();
		List<FunctionRole> functionRoles = functionRoleService
				.queryAllFunctionRoleInfoByRoleId(roleId);
		return functionRoles;
	}

	// ajax获取 系统配置的功能
	@RequestMapping(value = "/queryFunctions.html", method = RequestMethod.GET)
	@ResponseBody
	public List<Functions> queryFunctions() {
		List<Functions> funList = functionsService.queryAllFunctionsInfo();
		return funList;
	}

	// ajax获取 系统配置的角色
	@RequestMapping(value = "/queryRoles.html", method = RequestMethod.GET)
	@ResponseBody
	public List<Role> queryRoles() {
		List<Role> roleList = roleService.queryAllRoleInfo();
		return roleList;
	}

	// 查看所有的功能角色配置
	@RequestMapping(value = "/queryAllFunctionInfoBy.html")
	public String queryAllFunctionInfoBy(
			Model model,
			@RequestParam(value = "queryFunctionName", required = false) String queryFunctionName,
			@RequestParam(value = "queryFunctionPath", required = false) String queryFunctionPath,
			@RequestParam(value = "pageIndex", required = false) String pageIndex) {

		logger.info("getUserList ---- > queryFunctionName: "
				+ queryFunctionName);
		logger.info("getUserList ---- > queryFunctionPath: " + queryFunctionPath);
		logger.info("getUserList ---- > pageIndex: " + pageIndex);
		List<Functions> funList = null;
		// 设置页面容量
		int pageSize = Constants.pageSize;
		// 当前页码
		int currentPageNo = 1;

		if (queryFunctionName == null) {
			queryFunctionName = "";
		}
	
		if (queryFunctionPath == null) {
			queryFunctionPath = "";
		}

		if (pageIndex != null) {
			try {
				currentPageNo = Integer.valueOf(pageIndex);
			} catch (NumberFormatException e) {
				return "redirect:/user/syserror.html";
				// response.sendRedirect("syserror.jsp");
			}
		}
		// 总数量（表）
		int totalCount = functionsService.getFunctionCount(
				queryFunctionName, queryFunctionPath);
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
		funList = functionsService.getFunctionListBy(
				queryFunctionName, queryFunctionPath, currentPage, pageSize);
		model.addAttribute("list", funList);
		model.addAttribute("queryFunctionName", queryFunctionName);
		model.addAttribute("queryFunctionPath", queryFunctionPath);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPageNo", currentPageNo);
		return "functionRole/functions_list";
	}

}
