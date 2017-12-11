package com.titaniume.springboot.controller;

import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.titaniume.springboot.bean.UserLog;
import com.titaniume.springboot.cache.TitaniumeUserLogCache;

/**
 * 测试cors跨域
 * @author titaniume
 * 2017年12月7日下午8:04:11
 *
 */
@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	private TitaniumeUserLogCache titaniumeUserLogCache;
	
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public HashMap<String, Object> get(@RequestParam String name) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("title", "hello world");
		map.put("name", name);
		return map;
	}
	
	
	
	//测试缓存的时候记得先打开mongodb服务
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public UserLog get(@RequestParam(defaultValue = "1") Integer id) {
		return titaniumeUserLogCache.selectById(id);
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public UserLog update(@RequestParam(defaultValue = "1") Integer id) {
		UserLog bean = titaniumeUserLogCache.selectById(id);
		bean.setUserName("测试");
		bean.setCreateTime(new Date());
		titaniumeUserLogCache.updateById(bean);
		return bean;
	}

	@RequestMapping(value = "/del", method = RequestMethod.GET)
	public String del(@RequestParam(defaultValue = "1") Integer id) {
		return titaniumeUserLogCache.deleteById(id);
	}
}
