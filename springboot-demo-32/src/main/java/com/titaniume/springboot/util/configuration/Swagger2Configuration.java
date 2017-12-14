package com.titaniume.springboot.util.configuration;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger 配置
 * @author titaniume
 * 2017年12月14日下午1:30:11
 *
 */
@Configuration
@EnableSwagger2
public class Swagger2Configuration {
	
	
	@Bean
	public Docket accessToken(){
		return new Docket(DocumentationType.SWAGGER_2).groupName("api")  //定义组
		.select()  //选择哪些路径和api生成document
		.apis(RequestHandlerSelectors.basePackage("com.titaniume.springboot.controller")) //拦截包路径
		.paths(regex("/api/.*"))// 拦截的接口路径
		.build()  //创建
		.apiInfo(apiInfo()); // 配置说明
	}

	private ApiInfo apiInfo() {
		
		return new ApiInfoBuilder() //
				.title("titaniume") //
				.description("swagger2内容描述") //描述
				.termsOfServiceUrl("http://baidu.com") //
				.contact(new Contact("titaniume", "http://www.baidu.com","709467015@qq.com")) //联系
				.license("Apache License Version 2.0") //开源协议
				.licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")// 地址
				.version("1.0") //版本
				.build();
	}
}
