package com.titaniume.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 	注册Servlet ,Filter,Listener 。使用@ServletComponentScan 注解后，直接通过@WebServlet、
 *  @WebFilter、@WebListener 注解自动注册
 * @author titaniume
 * 2017年12月7日下午5:02:13
 *
 */
@EnableCaching   //开启缓存
@ServletComponentScan
@SpringBootApplication
public class SpringbootDemo28Application {
	

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemo28Application.class, args);
	}

	
}
