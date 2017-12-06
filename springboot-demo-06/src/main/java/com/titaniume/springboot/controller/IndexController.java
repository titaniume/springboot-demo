package com.titaniume.springboot.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.titaniume.springboot.bean.User;

/**
 * 控制类
 * @author titaniume
 * 2017年12月6日上午1:32:51
 *
 */
@RestController
@RequestMapping(value ="/index")
public class IndexController {
	
	@RequestMapping
	public String index(){
		return "hello world";
	}
	
	//@RequestParam 简单类型绑定 可以出来post get
	@RequestMapping(value ="/get")
	public Map<String, Object> get(@RequestParam String name){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("title", "hello world!");
		map.put("name", name);
		return map;
	}
	
	//@PathVariable 获取请求中的参数
	@RequestMapping(value ="/get/{id}/{name}")
	public User getUser(@PathVariable int id,@PathVariable String name){
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setDate(new Date());
		return user;
	}
	
	
}
