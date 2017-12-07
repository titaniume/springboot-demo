package com.titaniume.springboot.util.ordinary.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 自定义监听 启动和停止可以在控制台看到效果
 * @author titaniume
 * 2017年12月7日下午4:53:06
 *
 */
public class CustomListener implements ServletContextListener  {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("contextInitialized");
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("contextDestroyed");
	}

}
