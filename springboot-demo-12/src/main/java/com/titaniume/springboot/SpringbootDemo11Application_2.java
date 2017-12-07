package com.titaniume.springboot;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;

import com.titaniume.springboot.util.ordinary.filter.CustomFilter;
import com.titaniume.springboot.util.ordinary.listener.CustomListener;
import com.titaniume.springboot.util.ordinary.servlet.CustomServlet;


/**
 * 	注册Servlet ,Filter,Listener 方法二：通过实现 ServletContextInitializer 接口直接注册
 * @author titaniume
 * 2017年12月7日下午5:02:13
 *
 */
/*@SpringBootApplication
public class SpringbootDemo11Application_2 implements ServletContextInitializer{

	

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemo11Application_2.class, args);
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		servletContext.addServlet("customServlet", new CustomServlet()).addMapping("/method2Servlet");
		servletContext.addFilter("customFilter", new CustomFilter())
		.addMappingForServletNames(EnumSet.of(DispatcherType.REQUEST), true, "customServlet");
		servletContext.addListener(new CustomListener());
	}
}*/
