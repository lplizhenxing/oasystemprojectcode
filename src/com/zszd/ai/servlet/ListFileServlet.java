package com.zszd.ai.servlet;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = { "/listFile" }, name = "listFile")
public class ListFileServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String opr = request.getParameter("opr");
		if(opr.equals("list")){
			// 获取上传文件的目录
			String uploadFilePath = this.getServletContext().getRealPath(
					"/WEB-INF/upload");
			Map<String, String> fileNameMap = new HashMap<String, String>();
			listfile(new File(uploadFilePath), fileNameMap);
			// 将Map集合发送到listfile.jsp页面进行展示
			request.setAttribute("fileNameMap", fileNameMap);
			request.getRequestDispatcher("jsp/studydownload/study_download.jsp")
					.forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * 递归遍历指定目录下的所有文件
	 * 
	 * @param file
	 *            即可以是一个文件，也可以是一个文件目录
	 * @param fileNameMap
	 *            存储文件名的Map集合
	 */
	private void listfile(File file, Map<String, String> fileNameMap) {
		// 如果file是一个目录而不是文件
		if (!file.isFile()) {
			File[] files = file.listFiles();
			if (files != null && files.length > 0) {
				for (File fi : files) {
					listfile(fi, fileNameMap);
				}
			}
		} else {// 否则就是一个文件
				// 处理文件名，上传后的文件是以uuid_文件名的形式存储的，所有需要去掉文件名中的uuid部分
			String realname = file.getName().substring(
					file.getName().lastIndexOf("_") + 1);
			// 文件的原始名，文件的新的名称(也是用户上传的原始名称)
			fileNameMap.put(file.getName(), realname);
		}
	}
}
