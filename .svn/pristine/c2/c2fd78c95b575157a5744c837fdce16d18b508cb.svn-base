package com.zszd.ai.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zszd.ai.filter.LoginCheckFilter;
import com.zszd.ai.pojo.Resources;
import com.zszd.ai.service.resource.ResourceService;
import com.zszd.ai.service.resource.ResourceServiceImpl;

@WebServlet(urlPatterns = { "/workresult" }, name = "workresult")
public class WorkresultServlet extends HttpServlet {
	private static transient Log logger = LogFactory
			.getLog(LoginCheckFilter.class);

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
		HttpSession session = request.getSession();// 获取session
		String loginname = (String) session.getAttribute("login");
		String opr = request.getParameter("opr");
		ResourceService resourceService = new ResourceServiceImpl();
		if ("upload".equals(opr)) {

			String message = "";
			try {

				// 上传时生成一个临时文件保存目录
				String tempPath = this.getServletContext().getRealPath(
						"/WEB-INF/temp");
				File tempfile = new File(tempPath);
				// 使用Apache文件上传组件处理文件上传步骤
				// 1.创建一个DiskFileItemFactory工厂
				DiskFileItemFactory factory = new DiskFileItemFactory();
				// 设置工厂的缓存区大小，当上传文件的大小超过缓冲区的大小时，就会生成一个临时文件存放到指定的临时目录下
				factory.setSizeThreshold(1024 * 100);// 设置缓存区的大小是100KB，默认10KB
				// 设置上传时生成的临时文件的保存目录
				factory.setRepository(tempfile);
				// 2.创建一个文件上传解析器
				ServletFileUpload upload = new ServletFileUpload(factory);
				// 解决上传文件中文乱码问题
				upload.setHeaderEncoding("utf-8");
				// 监听文件上传进度
				upload.setProgressListener(new ProgressListener() {
					public void update(long pBytesRead, long pContentLength,
							int arg2) {
						logger.info("文件的大小是：" + pContentLength + "，当前已处理："
								+ pBytesRead);
					}
				});
				// 3.判断上传来的数据是否是上传表单的数据
				if (!ServletFileUpload.isMultipartContent(request)) {
					// 按照传统方式获取数据
					return;
				}
				// 设置上传单个文件的大小的最大值100M
				upload.setFileSizeMax(1024 * 1024 * 100);
				// 设置上传文件的总量的最大值1000M
				upload.setSizeMax(1024 * 1024 * 1000);
				// 4.使用ServletFileUpload解析器解析上传数据，解析的结果返回的是一个List<FileItem>结合，每个FileItem对应一个Form表单的输入项
				List<FileItem> list = upload.parseRequest(request);
				for (FileItem item : list) {
					// 如果fileItem中封装的是普通输入项数据
					if (item.isFormField()) {
						String name = item.getFieldName();
						// 解决普通输入项中文乱码问题
						String value = item.getString("utf-8");

					} else {// 否则封装的是上传文件
						// 得到文件的上传名称
						String fileName = item.getName();
						String ext = fileName.substring(fileName
								.lastIndexOf(".") + 1);
						logger.info("文件名称：" + fileName);
						if (fileName == null || fileName.trim().equals("")) {
							continue;
						}
						// 注意：不同浏览器提交的文件名称是不一样的，有的是带有文件路径的，而有的只有文件名
						// 截取路径，只获取文件名称
						fileName = fileName.substring(fileName
								.lastIndexOf("/") + 1);
						// 获取上传文件的后缀名，可用于验证上传文件是否合法
						String fileExtname = fileName.substring(fileName
								.lastIndexOf(".") + 1);
						
						// 获取上传文件的前面的名称
						String filePreName = fileName.substring(0,fileName
								.lastIndexOf(".") );

						// 得到上传文件的保存路径，将上传的文件存放在WEB-INF下，不允许外界直接访问，保证上传文件的安全
						String savePath = null;
						String oapath = null;
						int type = 0;// 类型：0 图片 1 视频 2 文件
						if (fileExtname.equals("jpg") || fileExtname.equals("png") || fileExtname.equals("bmp")) {
							type = 0;
                            savePath = this.getServletContext().getRealPath(
									"/statics/resources/photos");
                            oapath = "statics/resources/photos";
						} else if (fileExtname.equals("mp4") || fileExtname.equals("avi") || fileExtname.equals("wmv")) {
							type = 1;
							savePath = this.getServletContext().getRealPath(
									"/statics/resources/videos");
                            oapath = "statics/resources/videos";
						} else {
							type = 2;
							savePath = this.getServletContext().getRealPath(
									"/statics/resources/files");
							oapath = "statics/resources/files";
						}
						
                        Date date = new Date();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        String saveTime = sdf.format(date);
						String saveFilepath = savePath + "\\" +  saveTime;
						String oaFilepath = oapath + "\\" +  saveTime;
						File file = new File(saveFilepath);
						// 若目录不存在
						if (!file.exists()) {
							// 创建目录
							file.mkdirs();
						}
													
						String saveFilename = fileName;
						// 获取item中文件上传的输入流
						InputStream in = item.getInputStream();
						// 创建一个文件输出流
						FileOutputStream out = new FileOutputStream(
								saveFilepath + "\\" + saveFilename);
						// 创建一个缓冲区
						byte[] bytes = new byte[1024];
						int len = 0;
						while ((len = in.read(bytes)) != -1) {
							out.write(bytes, 0, len);
						}
						in.close();
						out.close();
						// 删除处理文件上传时生成的临时文件
						item.delete();
						
						//写入表里
						Resources resource = new Resources();
						resource.setName(filePreName);
						resource.setPath(oaFilepath + "\\" + saveFilename);
						resource.setCreateBy(loginname);
						resource.setType(type);
						int row = resourceService.insertResourceRecord(resource);
						if(row>0){
							message = "文件上传成功";
						}
					}
				}
			} catch (FileUploadBase.FileSizeLimitExceededException e) {
				e.printStackTrace();
				message = "单个文件超出最大值！";
			} catch (FileUploadBase.SizeLimitExceededException e) {
				e.printStackTrace();
				message = "上传文件的总的大小超出限制的最大值！";
			} catch (Exception e) {
				e.printStackTrace();
				message = "文件上传失败,请联系管理员";
			} finally {
				request.setAttribute("message", message);
				request.getRequestDispatcher(
						"/jsp/uploadFile/uploadFile_list.jsp").forward(request,
						response);
			}
		}
	}
}
