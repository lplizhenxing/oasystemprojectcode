package com.zszd.ai.tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * 
 * @ClassName       ConfigManager
 * @Description    单例模式
 *  1.一个类只有一个实例          private ConfigManager()
 *  2.它必须自行创建这个实例  configManager = new ConfigManager();
 *  3.它必须自行向整个系统提供这个实例  public static ConfigManager getInstance()
 * @author            lizx
 * @date           2018-2-11        下午10:19:00
 */
public class ConfigManager {

	//初始化就加载 不具备延迟加载
	private static ConfigManager configManager = new ConfigManager();
	
	private static Properties properties;

	// 私有构造器-读取数据库配置文件
	private ConfigManager() {
		String configFile = "database.properties";
		properties = new Properties();
		InputStream is = ConfigManager.class.getClassLoader()
				.getResourceAsStream(configFile);
		try {
			properties.load(is);
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 全局访问点
	//synchronized 解决线程不安全的问题 但是处理不高
	// public static synchronized ConfigManager getInstance() {
	// if (configManager == null) {
	// configManager = new ConfigManager();
	// }
	// return configManager;
	// }

	public static  ConfigManager getInstance() {
		return configManager;
	}

	public String getValue(String key) {
		return properties.getProperty(key);
	}
}
