package com.zszd.ai.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * 编码过滤器
 * @author lizx 20180103
 *
 */
public class CharacterEncodingFilter implements Filter {
	private static transient Log logger = LogFactory.getLog(CharacterEncodingFilter.class);

	private String charset = null;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		logger.debug("执行CharacterEncodingFilter的destroy()方法");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		logger.debug("执行CharacterEncodingFilter的doFilter()方法");
		if(charset!=null){
			arg0.setCharacterEncoding(charset);
			arg1.setCharacterEncoding(charset);
		}
		arg2.doFilter(arg0, arg1);
		logger.debug("退出CharacterEncodingFilter的doFilter()方法");

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		logger.debug("执行CharacterEncodingFilter的init()方法");
		String initParam = arg0.getInitParameter("charset");
		if (initParam != null && (initParam = initParam.trim()).length() != 0) {
			charset = initParam;
		}
	}

}
