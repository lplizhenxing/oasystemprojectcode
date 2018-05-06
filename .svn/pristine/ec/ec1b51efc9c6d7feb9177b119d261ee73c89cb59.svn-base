package com.zszd.ai.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zszd.ai.pojo.SysUser;
import com.zszd.ai.service.sysuser.SysUserService;
import com.zszd.ai.service.sysuser.SysUserServiceImpl;
import com.zszd.ai.tools.MakeMD5;

/**
 * 系统用户
 * 
 * @author lizx 20180103
 * 
 */
@WebServlet(urlPatterns = { "/user" }, name = "user")
public class UserServlet extends HttpServlet {

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
		String opr = request.getParameter("opr");
		HttpSession session = request.getSession();// 获取session
		String name = (String) session.getAttribute("login");
		ServletContext application = this.getServletContext();// 获取application
		PrintWriter out = response.getWriter();
		SysUserService sysUserService = new SysUserServiceImpl();
		
		if ("modify".equals(opr)) {
			request.setCharacterEncoding("UTF-8");
			SysUser sysUser = sysUserService.getUserInfoByUserName(name);
			int userId = sysUser.getId();
			String password = request.getParameter("password");
			String md5pwd = null;
			if (password != null) {
				md5pwd = MakeMD5.getMD5(password); // 采用MD5算法加密
			} else {
				md5pwd = sysUser.getPassword();
			}
			sysUser.setId(userId);
			sysUser.setPassword(md5pwd);
			int row = sysUserService.updateUserPasswordInfo(sysUser);
			if (row > 0) {
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
				session.invalidate();
				out.print("<script type='text/javascript'>");
				out.print("alert('密码更新成功，点击确认退出重新登录！');");
				out.print("location.href=\"" + basePath + "login.jsp\";");
				out.print("</script>");

			} else {
				out.print("<script type='text/javascript'>");
				out.print("alert('密码更新失败，点击确认重新修改密码！');");
				out.print("location.href=\"" + basePath
						+ "user/user_modify.jsp\";");
				out.print("</script>");
			}
		}
	}
}
