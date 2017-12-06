package com.titaniume.springboot.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.titaniume.springboot.bean.User;

/**
 * 
 * @author titaniume
 * 2017年12月6日上午2:20:02
 *
 */
@RestController
@RequestMapping(value ="/index")
public class IndexController {
	
	//读取属性
	@Value(value = "${titaniume.rodmom}")
	private String rodmom;
	
	
	@Value(value ="${titaniume.number}")
	private int number;
	
	@Value(value ="${titaniume.desc}")
	private String desc;
	
	@RequestMapping
	public String index(){
		
		return "hello world!";
	}
	
	@RequestMapping(value ="/get")
	public Map<String, Object> get(@RequestParam String name){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("title", "hello world!");
		map.put("name", name);
		map.put("rodmom", rodmom);
		map.put("number", number);
		map.put("desc", desc);
		return map;
	}
	
	@RequestMapping(value="/find/{id}/{name}")
	public User get(@PathVariable int id,@PathVariable String name){
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setDate(new Date()); 
		System.out.println(user.getDate());
		return user;
	}
	
	
}
