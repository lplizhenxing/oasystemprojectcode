package com.zszd.ai.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zszd.ai.pojo.Sensitivewords;
/**
 * 敏感词处理过滤器
 * @author lizx 20180103
 *
 */
public class WordFilter implements Filter {
	private static transient Log logger = LogFactory.getLog(WordFilter.class);

	private ServletContext application = null;

	@Override
	public void destroy() {
		logger.debug("执行WordFilter的destroy()方法");

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		logger.debug("执行WordFilter的doFilter()方法");
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		List<Sensitivewords> postContents = (List<Sensitivewords>) application
				.getAttribute("ALL_SensitiveWords_List");

		String postContent = null;
		if(request.getParameter("postContent")!=null){
			//过滤帖子内容
			postContent = request.getParameter("postContent");
		}else if(request.getParameter("content")!=null){
			//过滤评论内容
			postContent = request.getParameter("content");
		}
		
		logger.debug("request获取的postContent=" + postContent);
		if (postContent != null) {
			List<Integer> list = new ArrayList<Integer>();
			StringBuffer sb = new StringBuffer(postContent);
			for (int i = 0; i < sb.length(); i++) {
				if (sb.charAt(i) == ' ') {
					sb.deleteCharAt(i);
					list.add(i);
					i--;
				}
			}
			postContent = sb.toString();
//			if (postContent != null) {
//				for (Sensitivewords sensitivewords : postContents) {
//					String xx = "";
//					for (int j = 0; j < sensitivewords.getContent().length(); j++) {
//						xx += "*";
//					}
//					postContent = postContent.replace(
//							sensitivewords.getContent(), xx);
//				}
//			}
//
//			StringBuffer nsb = new StringBuffer(postContent);
//			for (int i = list.size() - 1; i >= 0; i--) {
//				nsb.insert(list.get(i), " ");
//			}
//			postContent = nsb.toString();
			if(request.getParameter("postContent")!=null){
				//过滤帖子内容
				request.setAttribute("WordFilterContent", postContent);
			}else if(request.getParameter("content")!=null){
				//过滤评论内容
				request.setAttribute("WordFilterContent", postContent);
			}
			
			
			
		}
		logger.debug("过滤后的postContent=" + postContent);
		
		arg2.doFilter(arg0, arg1);
		logger.debug("退出LoginCheckFilter的doFilter()方法");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		application = arg0.getServletContext();
		logger.debug("执行WordFilter的init()方法");

	}

}
