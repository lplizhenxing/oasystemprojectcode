package com.zszd.ai.controller;

import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zszd.ai.pojo.Employee;
import com.zszd.ai.pojo.SysUser;
import com.zszd.ai.service.employee.EmployeeService;
import com.zszd.ai.service.employee.EmployeeServiceImpl;
import com.zszd.ai.service.sysuser.SysUserService;
import com.zszd.ai.service.sysuser.SysUserServiceImpl;
import com.zszd.ai.tools.Constants;
import com.zszd.ai.tools.MakeMD5;

@Controller
public class LoginController {
	private Logger logger = Logger.getLogger(LoginController.class);

	@Resource
	SysUserService sysUserService = new SysUserServiceImpl();

	@Resource
	EmployeeService employeeService = new EmployeeServiceImpl();

	// 实现跳转到登录页
	@RequestMapping(value = "/login.html")
	public String login() {
		return "login";
	}

	// 实现登录
	@RequestMapping(value = "/dologin.html", method = RequestMethod.POST)
	public String doLogin(@RequestParam String logname,
			@RequestParam String logpass, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		logger.info("doLogin====");

		if (logname == null || logname.equals("")) {
			request.setAttribute("error", "用户名不能为空");
			return "login";
		} else if (logpass == null || logpass.equals("")) {
			request.setAttribute("error", "密码不能为空");
			return "login";
		} else {
			// 采用MD5算法加密
			logpass = MakeMD5.getMD5(logpass);
			SysUser sysUser = sysUserService.login(logname, logpass);
			if (null != sysUser) {// 登录成功
				Employee employee = employeeService
						.getEmployeeInfoByLoginName(logname);

				String ipaddress = request.getRemoteAddr();// 获取登录的IP地址
				String nologin = request.getParameter("nologin");// 是否10分钟免登陆

				int cookTime = 0;
				if (nologin == null) {
					cookTime = -1; // 正值表示有效时间 0的时候表示立即失效 负值或者不设置表示关闭窗口就失效
				} else {
					cookTime = 600;
				}

				sysUser.setLogincount(sysUser.getLogincount() + 1);// 登录次数+1
				sysUser.setIsOnline("Y");// 设置登录状态
				sysUser.setLoginIPaddress(ipaddress);// 设置登录IP地址

				// 更新登录记录 包括最后登录时间，登录次数，是否登录，登录IP地址
				int rows = sysUserService.updateLoginRecord(sysUser);

				// 存入cookie对象属性
				URLEncoder.encode(logname, "UTF-8");
				Cookie namecookie = new Cookie("name", logname);// 登录名称
				Cookie passwordcookie = new Cookie("password", logpass);// 登录名称
				namecookie.setMaxAge(cookTime);
				passwordcookie.setMaxAge(cookTime);
				response.setCharacterEncoding("UTF-8");
				response.addCookie(namecookie);
				response.addCookie(passwordcookie);

				// 页面跳转(userindex.jsp) 放入session
				session.setAttribute(Constants.EMPlOYEE_SESSION, employee);
				session.setAttribute(Constants.SYSUSER_SESSION, sysUser);
				return "redirect:/sys/main.html";
			} else {
				// 页面跳转(login.jsp) 带出提示信息
//				request.setAttribute("error", "用户名或者密码不正确");
//				return "login";
				throw new RuntimeException("用户名或者密码不正确");
			}
		}
	}
	
//	@ExceptionHandler(value={RuntimeException.class})
//	public String handlerException(RuntimeException e, HttpServletRequest request){
//		request.setAttribute("error", "用户名或者密码不正确");
//		return "error";
//	}

	@RequestMapping(value = "logout.html")
	public String logout(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("name")) {
					cookie.setValue("");
					cookie.setMaxAge(0);
					response.addCookie(cookie);

				} else if (cookie.getName().equals("password")) {
					cookie.setValue("");
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		}
		session.removeAttribute(Constants.SYSUSER_SESSION);
		return "login";
	}

	@RequestMapping(value = "/sys/main.html")
	public String main(HttpSession session) {
		if (session.getAttribute(Constants.SYSUSER_SESSION) == null) {
			return "redirect:login.html";
		}
		return "userindex";
	}

	// 实现免登录
	@RequestMapping(value = "/mianlogin.html", method = RequestMethod.GET)
	public String doLogin(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		logger.info("mianLogin====");

		String logname = request.getParameter("username");// 登录名称
		String logpass = request.getParameter("password");// 登录密码
		
		SysUser sysUser = sysUserService.login(logname, logpass);
		if (null != sysUser) {// 登录成功
			Employee employee = employeeService
					.getEmployeeInfoByLoginName(logname);

			String ipaddress = request.getRemoteAddr();// 获取登录的IP地址
			sysUser.setLogincount(sysUser.getLogincount() + 1);// 登录次数+1
			sysUser.setIsOnline("Y");// 设置登录状态
			sysUser.setLoginIPaddress(ipaddress);// 设置登录IP地址

			// 更新登录记录 包括最后登录时间，登录次数，是否登录，登录IP地址
			int rows = sysUserService.updateLoginRecord(sysUser);

			// 页面跳转(userindex.jsp) 放入session
			session.setAttribute(Constants.EMPlOYEE_SESSION, employee);
			session.setAttribute(Constants.SYSUSER_SESSION, sysUser);
			return "redirect:/sys/main.html";
		} else {
			// 页面跳转(login.jsp) 带出提示信息
			request.setAttribute("error", "用户名或者密码不正确");
			return "login";
		}
	}

}
