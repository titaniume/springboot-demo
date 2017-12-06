package com.titaniume.springboot.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class WebController {
	
	private static final Logger Logger = LoggerFactory.getLogger(WebController.class);
	
	
	@RequestMapping("index")
	public String index(ModelMap map){
		Logger.info("这里是Controller");
		map.put("title", "hello freemaker");
		return "index";  //不要在最前面加上/,linux下面会报错
	}
}
