package com.zszd.ai.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zszd.ai.pojo.SysUser;
/**
 * 在线用户
 * @author lizx 20180103
 *
 */
public class OnlineUser implements HttpSessionBindingListener {
	private static transient Log logger = LogFactory.getLog(OnlineUser.class);

	private SysUser sysUser;

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		logger.debug("执行OnlineUser的valueBound()方法");
		ServletContext application = arg0.getSession().getServletContext();
		List<SysUser> onlineUsers = (List<SysUser>) application
				.getAttribute("ONLINE_USERS");
		onlineUsers.add(sysUser);
		logger.debug("用户" + sysUser.getName() + "上线");
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		logger.debug("执行OnlineUser的valueUnbound()方法");
		ServletContext application = arg0.getSession().getServletContext();
		List<SysUser> onlineUsers = (List<SysUser>) application
				.getAttribute("ONLINE_USERS");
		onlineUsers.remove(sysUser);
		logger.debug("用户" + sysUser.getName() + "下线");
	}

}
