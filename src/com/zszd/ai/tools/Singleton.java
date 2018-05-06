package com.zszd.ai.tools;
/**
 * 
 * @ClassName       Singleton
 * @Description    静态内部类实现单例模式  线程安全又具有延迟加载的特点
 * @author            lizx
 * @date           2018-2-11        下午10:43:57
 */
public class Singleton {

	private static Singleton singleton;
	private Singleton(){
		//放置只执行一次的业务代码操作
	}
	
	//静态内部类
	public static class SingletonHelper{
		private static final Singleton INSTANCE = new Singleton();
	}
	
	public static Singleton getInstance(){
		singleton = SingletonHelper.INSTANCE;
		return singleton;
	}
	
	public static Singleton test(){
		return singleton;
	}
}
