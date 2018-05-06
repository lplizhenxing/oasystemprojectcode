package com.zszd.ai.listener;

import java.util.ArrayList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * 在线用户
 * @author lizx 20180103
 *
 */
public class OnlineUserInitListener implements ServletContextListener {
	private static transient Log logger = LogFactory.getLog(OnlineUserInitListener.class);

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		logger.debug("执行OnlineUserInitListener的contextDestroyed()方法");

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		logger.debug("执行OnlineUserInitListener的contextInitialized()方法");
        arg0.getServletContext().setAttribute("ONLINE_USERS", new ArrayList());
	}

}
