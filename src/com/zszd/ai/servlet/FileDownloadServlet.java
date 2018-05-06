package com.zszd.ai.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/fileDownloadServlet" }, name = "fileDownloadServlet")
public class FileDownloadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String opr = request.getParameter("opr");
		if (opr.equals("download")) {
			// 获取要下载的文件名
			String filename = request.getParameter("filename");
			//filename = new String(filename.getBytes("iso8859-1"), "utf-8");
			// 上传的文件都是保存在/WEB-INF文件夹下
			String fileSaveRootPath = this.getServletContext().getRealPath(
					"/WEB-INF/upload");
			String filePath = findFilePathByFilename(filename, fileSaveRootPath);
			File file = new File(filePath + "\\" + filename);
			String message = "";
			// 如果文件不存在
			if (!file.exists()) {
				request.setAttribute("message", "您要下载的资源已被删除！");
				request.getRequestDispatcher(
						"/jsp/studydownload/study_download.jsp").forward(
						request, response);
				return;
			}
			// 处理文件名
			String realname = filename.substring(filename.lastIndexOf("_") + 1);
			// 设置响应头，控制浏览器下载该文件
			response.setHeader("content-disposition", "attachment;filename="
					+ URLEncoder.encode(realname, "utf-8"));
			// 读取要下载的文件，保存到文件输入流中
			FileInputStream in = new FileInputStream(filePath + "\\" + filename);
			// 创建输出流
			OutputStream out = response.getOutputStream();
			byte[] bytes = new byte[1024];
			int len = 0;
			while ((len = in.read(bytes)) != -1) {
				out.write(bytes, 0, len);
			}
			in.close();
			out.close();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * 通过文件名和存储上传根路径找出要下载的文件所在路径
	 * 
	 * @param filename
	 *            文件名
	 * @param fileSaveRootPath
	 *            存储上传根路径
	 * @return String 文件所在的路径
	 */
	private String findFilePathByFilename(String filename,
			String fileSaveRootPath) {
		int hashcode = filename.hashCode();
		int dir1 = hashcode & 0xf; // 0--15
		int dir2 = (hashcode & 0xf0) >> 4; // 0-15
		String path = fileSaveRootPath + "\\" + dir1 + "\\" + dir2;
		File file = new File(path);
		// 如果目录不存在，则创建
		if (!file.exists()) {
			file.mkdirs();// .mkdirs()可以在不存在的文件夹下创建目录，而.mkdir()只能在已存在的文件夹下创建目录
		}
		return path;
	}

}
