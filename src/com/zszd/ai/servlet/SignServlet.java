package com.zszd.ai.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zszd.ai.pojo.SignRecord;
import com.zszd.ai.service.signrecord.SignRecordService;
import com.zszd.ai.service.signrecord.SignRecordServiceImpl;
import com.zszd.ai.tools.DateUtil;

@WebServlet(urlPatterns={"/sign"},name="sign")
public class SignServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + path + "/";
		
		HttpSession session = request.getSession();// 获取session
		String name = (String) session.getAttribute("login");
		int roleId = (Integer) session.getAttribute("roleId");
		int companyId = (Integer) session.getAttribute("companyId");
		
		PrintWriter out = response.getWriter();
		SignRecordService signRecodService = new SignRecordServiceImpl();
		String opr = request.getParameter("opr");
		if ("list".equals(opr)) {
			List<SignRecord> list = null;
			if (roleId == 6) {
				list = signRecodService.queryAllSignRecordInfoByCompanyIdAndName(companyId,name);
			}else if (roleId == 4 || roleId == 5) {
				list = signRecodService.queryAllSignRecordInfoByCompanyId(companyId);
			} else {
				list = signRecodService.queryAllSignRecordInfo();
			}
			request.setAttribute("list", list);
			request.getRequestDispatcher("jsp/sign/sign_list.jsp").forward(
					request, response);
		} else if ("sign".equals(opr)) {
			String signDate = DateUtil.getTime(); 
			List<SignRecord> list = signRecodService.queryAllSignRecordInfoByNameAndSignDate(name,signDate);
			if(list.size()>0){
				out.print("<script type='text/javascript'>");
				out.print("alert('今天已经签到，点击确认回到签到记录页面！');");
				out.print("location.href=\"" + basePath + "sign?opr=list\";");
				out.print("</script>");
			}else{
				List<SignRecord> signOutlist = signRecodService.queryAllSignRecordInfoByNameAndSignOutDate(name,signDate);
				if(signOutlist.size()>0){
					int rows =  signRecodService.updateSignRecordInfoByNameAndSignDate(name,signDate);
					if (rows > 0) {
						out.print("<script type='text/javascript'>");
						out.print("alert('签到成功，点击确认回到签到页面！');");
						out.print("location.href=\"" + basePath + "sign?opr=list\";");
						out.print("</script>");
					} else {
						out.print("<script type='text/javascript'>");
						out.print("alert('已经签到，请查看签到的页面！');");
						out.print("location.href=\"" + basePath
								+ "sign?opr=list\";");
						out.print("</script>");
					}
				}else{
					int rows =  signRecodService.insertSignRecordInfoByNameAndSignDate(name,signDate);
					if (rows > 0) {
						out.print("<script type='text/javascript'>");
						out.print("alert('签到成功，点击确认回到签到页面！');");
						out.print("location.href=\"" + basePath + "sign?opr=list\";");
						out.print("</script>");
					} else {
						out.print("<script type='text/javascript'>");
						out.print("alert('已经签到，请查看签到的页面！');");
						out.print("location.href=\"" + basePath
								+ "sign?opr=list\";");
						out.print("</script>");
					}
				}
				
			}
			
		} else if ("signOut".equals(opr)) {
			String signOutDate = DateUtil.getTime(); 
			List<SignRecord> list = signRecodService.queryAllSignRecordInfoByNameAndSignOutDate(name,signOutDate);
			if(list.size()>0){
				out.print("<script type='text/javascript'>");
				out.print("alert('今天已经签退，点击确认回到签到记录页面！');");
				out.print("location.href=\"" + basePath + "sign?opr=list\";");
				out.print("</script>");
			}else{
				List<SignRecord> signlist = signRecodService.queryAllSignRecordInfoByNameAndSignDate(name,signOutDate);
				if(signlist.size()>0){
					int rows =  signRecodService.updateSignRecordInfoByNameAndSignOutDate(name,signOutDate);
					if (rows > 0) {
						out.print("<script type='text/javascript'>");
						out.print("alert('签退成功，点击确认回到签到页面！');");
						out.print("location.href=\"" + basePath + "sign?opr=list\";");
						out.print("</script>");
					} else {
						out.print("<script type='text/javascript'>");
						out.print("alert('已经签退，请查看签到的页面！');");
						out.print("location.href=\"" + basePath
								+ "sign?opr=list\";");
						out.print("</script>");
					}
				}else{
					int rows =  signRecodService.insertSignRecordInfoByNameAndSignOutDate(name,signOutDate);
					if (rows > 0) {
						out.print("<script type='text/javascript'>");
						out.print("alert('签退成功，点击确认回到签到页面！');");
						out.print("location.href=\"" + basePath + "sign?opr=list\";");
						out.print("</script>");
					} else {
						out.print("<script type='text/javascript'>");
						out.print("alert('已经签退，请查看签到的页面！');");
						out.print("location.href=\"" + basePath
								+ "sign?opr=list\";");
						out.print("</script>");
					}
				}
				
			}
		}
	}

}
