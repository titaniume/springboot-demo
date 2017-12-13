package com.titaniume.springboot.controller;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class WebController {
	
	private static final Logger Logger = LoggerFactory.getLogger(WebController.class);
	
	
	@RequestMapping(value = "/index")
	public String index(ModelMap map, HttpSession httpSession) {
		map.put("title", "第二个应用：sessionID=" + httpSession.getId());
		System.out.println("sessionID=" + httpSession.getId());
		return "index";
	}
	
	@RequestMapping("error")
	public String error(){
		throw new RuntimeException("测试异常!");
	}

	public static Logger getLogger() {
		return Logger;
	}
}
