package com.zszd.ai.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zszd.ai.pojo.Oadev;
import com.zszd.ai.service.oadev.OadevService;
import com.zszd.ai.service.oadev.OadevServiceImpl;

@WebServlet(urlPatterns = { "/oadev" }, name = "oadev")
public class OadevServlet extends HttpServlet {

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
		OadevService oadevService = new OadevServiceImpl();
		String opr = request.getParameter("opr");
		if ("list".equals(opr)) {
			List<Oadev> list = oadevService.queryAllOadevInfo();
			request.setAttribute("list", list);
			request.getRequestDispatcher("jsp/oadev/oadev_list.jsp").forward(
					request, response);
		} 
	}
}
