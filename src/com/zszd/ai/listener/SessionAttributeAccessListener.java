package com.zszd.ai.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * session属性监听
 * @author lizx 20180103
 *
 */
public class SessionAttributeAccessListener implements
		HttpSessionAttributeListener {
	private static transient Log logger = LogFactory.getLog(SessionAttributeAccessListener.class);

	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		logger.debug("执行SessionAttributeAccessListener的attributeAdded()方法");
		logger.debug("变量"+arg0.getName()+"被添加到session中，其类型为："+ arg0.getValue().getClass().getName());
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		logger.debug("执行SessionAttributeAccessListener的attributeRemoved()方法");
		logger.debug("变量"+arg0.getName()+"被从session中移除");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		logger.debug("执行SessionAttributeAccessListener的attributeReplaced()方法");
		logger.debug("session中的变量"+arg0.getName()+"被替换，其旧值为"+arg0.getValue());
	}

}
