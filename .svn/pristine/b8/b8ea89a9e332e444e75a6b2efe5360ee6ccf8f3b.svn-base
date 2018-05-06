package com.zszd.ai.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zszd.ai.pojo.Sensitivewords;
import com.zszd.ai.service.sensitivewords.SensitivewordsService;
import com.zszd.ai.service.sensitivewords.SensitivewordsServiceImpl;
/**
 * 敏感词
 * @author lizx 20180103
 *
 */
@WebServlet(urlPatterns = { "/sensitivewords" }, name = "sensitivewords")
public class SensitivewordsServlet extends HttpServlet {

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
		String basePath = request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ path + "/";
		SensitivewordsService sensitivewordsService = new SensitivewordsServiceImpl();
		ServletContext application = this.getServletContext();
		String opr = request.getParameter("opr");
		PrintWriter out = response.getWriter();
		if("add".equals(opr)){
			String sensitivewords = request.getParameter("sensitivewords");
			Sensitivewords sensitiveword = new Sensitivewords();
			sensitiveword.setContent(sensitivewords);
			try{
				int row = sensitivewordsService.addSensitiveWordsInfo(sensitiveword);
				List<Sensitivewords>  senList = sensitivewordsService.getAllSensitivewords();			
				if (row>0) {
		    		application.setAttribute("ALL_SensitiveWords_List", senList);
					out.print("<script type='text/javascript'>");
					out.print("alert('敏感词添加成功，点击确认回到首页！');");
					out.print("location.href=\"" + basePath
							+ "post?opr=search\";");
					out.print("</script>");
				} else {
					out.print("<script type='text/javascript'>");
					out.print("alert('敏感词添加失败，记录已存在，请重新添加！');");
					out.print("location.href=\"" + basePath
							+ "jsp/sensitivewords/sensitivewords_add.jsp\";");
					out.print("</script>");
				}
			}catch(Exception e){
				out.print("<script type='text/javascript'>");
				out.print("alert('敏感词添加失败，记录已存在，点击确认返回首页！');");
				out.print("location.href=\"" + basePath
						+ "post?opr=search\";");
				out.print("</script>");
			}
		}
	}
}
