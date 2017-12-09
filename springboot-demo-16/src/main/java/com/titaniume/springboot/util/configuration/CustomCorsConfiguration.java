package com.titaniume.springboot.util.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 全局配置 cors跨域
 * @author titaniume
 * 2017年12月7日下午10:06:59
 *
 */
@Configuration
public class CustomCorsConfiguration {
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				//registry.addMapping("/api/**").allowedOrigins("http://127.0.0.1:8080"); //指定那个域名Ip段可以访问api/**下面的方法
			}
		};
	}
}
