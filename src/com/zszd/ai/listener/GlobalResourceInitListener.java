package com.zszd.ai.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zszd.ai.pojo.Sensitivewords;
import com.zszd.ai.pojo.Workpoint;
import com.zszd.ai.service.sensitivewords.SensitivewordsService;
import com.zszd.ai.service.sensitivewords.SensitivewordsServiceImpl;
import com.zszd.ai.service.workpoint.WorkPointService;
import com.zszd.ai.service.workpoint.WorkPointServiceImpl;
/**
 * 全局资源监听器
 * @author lizx 20180103
 *
 */
public class GlobalResourceInitListener implements ServletContextListener {
	private static transient Log logger = LogFactory.getLog(GlobalResourceInitListener.class);

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		logger.debug("执行GlobalResourceInitListener的contextDestroyed()方法");

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
        logger.debug("执行GlobalResourceInitListener的contextInitialized()方法");
        ServletContext application = arg0.getServletContext();
        WorkPointService workPointService = new WorkPointServiceImpl();
        SensitivewordsService sensitivewordsService = new SensitivewordsServiceImpl();
        try {
            List<Sensitivewords> sensitivewords = sensitivewordsService.getAllSensitivewords();
            List<Workpoint> workpoints = workPointService.queryAllWorkPointInfo();
            logger.debug("初始化得到"+workpoints.size()+"个工时记录");
            logger.debug("初始化得到"+sensitivewords.size()+"个敏感词记录");
    		application.setAttribute("ALL_Workpoint_List", workpoints);
    		application.setAttribute("ALL_SensitiveWords_List", sensitivewords);
		} catch (Exception e) {
			logger.debug("初始化错误！");
			e.printStackTrace();
		}
	}

}
