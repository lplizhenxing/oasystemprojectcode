package com.zszd.ai.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zszd.ai.pojo.Draw;
import com.zszd.ai.service.DrawService;
import com.zszd.ai.service.impl.DrawServiceImpl;

@WebServlet(urlPatterns = { "/DrawServlet" }, name = "DrawServlet")
public class DrawServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		doGet(req, resp);

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("login");
		String prizeName = request.getParameter("name");
	    //增加抽奖记录
		Draw draw = new Draw(userName, new Date(), 10, prizeName);
		DrawService ds = new DrawServiceImpl();
		ds.addDrawRecord(draw);
      
	}
}
