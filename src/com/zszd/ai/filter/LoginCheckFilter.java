package com.zszd.ai.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * 登录检查过滤器
 * @author lizx 20180103
 *
 */
public class LoginCheckFilter implements Filter {
	private static transient Log logger = LogFactory.getLog(LoginCheckFilter.class);

	@Override
	public void destroy() {
		logger.debug("执行LoginCheckFilter的destroy()方法");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		logger.debug("执行LoginCheckFilter的doFilter()方法");
        HttpServletRequest request = (HttpServletRequest) arg0;
        HttpServletResponse response = (HttpServletResponse) arg1;
        HttpSession session = request.getSession(false);
        
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        if(session!=null&&session.getAttribute("login")!=null){
        	arg2.doFilter(arg0, arg1);
        }else{
        	response.sendRedirect(request.getContextPath()+"/401.jsp");
        }
        logger.debug("退出LoginCheckFilter的doFilter()方法");

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		logger.debug("执行LoginCheckFilter的init()方法");
	}

}
