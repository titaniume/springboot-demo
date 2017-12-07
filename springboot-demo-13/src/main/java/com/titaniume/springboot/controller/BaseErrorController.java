/*package com.titaniume.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

*//**
 * 
 * Spring Boot 将所有的错误默认映射到/error， 实现ErrorController
 * @author titaniume
 * 2017年12月7日下午1:52:21
 * 
 *//*
@Controller
@RequestMapping(value = "error")
public class BaseErrorController implements ErrorController {
	
	private static final Logger logger = LoggerFactory.getLogger(BaseErrorController.class);

	@Override
	public String getErrorPath() {
		logger.info("出错啦！进入自定义错误控制器--BaseErrorController");
		return "error/error";  //返回templates下面的error/error.ftl
	}

	@RequestMapping
	public String error() {
		return getErrorPath();
	}

}*/