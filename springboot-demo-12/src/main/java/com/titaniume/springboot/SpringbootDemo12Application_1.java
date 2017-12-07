package com.titaniume.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.titaniume.springboot.util.ordinary.filter.CustomFilter;
import com.titaniume.springboot.util.ordinary.listener.CustomListener;
import com.titaniume.springboot.util.ordinary.servlet.CustomServlet;

/*
 * 	注册Servlet ,Filter,Listener 方式一:通过注册 ServletRegistrationBean、 FilterRegistrationBean 和
 *	ServletListenerRegistrationBean 获得控制
 * @author titaniume
 * 2017年12月7日下午5:02:13
 *
 */
@SpringBootApplication
public class SpringbootDemo12Application_1 {

	/*// 注册Bean ---Servlet
	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		return new ServletRegistrationBean(new CustomServlet(), "/method1Servlet");

	}

	// 注册Bean ---Filter
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
	//	return new FilterRegistrationBean(new CustomFilter());  //这种是拦截全局，所以请求都会被拦截
		return new FilterRegistrationBean(new CustomFilter(),servletRegistrationBean());   //只是拦截CustomServlet 
	}
	
	
	//注册Bean ---Listener
	@Bean
	public ServletListenerRegistrationBean<CustomListener> servletListenerRegistrationBean() { 
		return new ServletListenerRegistrationBean<CustomListener>(new CustomListener());

	}
*/

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemo12Application_1.class, args);
	}
}
