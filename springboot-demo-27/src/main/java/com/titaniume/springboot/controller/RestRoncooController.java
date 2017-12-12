package com.titaniume.springboot.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.titaniume.springboot.bean.UserLog;
import com.titaniume.springboot.cache.TitaniumeUserLogCache;

@RestController
@RequestMapping(value = "/rest", method = RequestMethod.POST)
public class RestRoncooController {

	@Autowired
	private TitaniumeUserLogCache titaniumeUserLogCache;

	@RequestMapping(value = "/update")
	public UserLog update(@RequestBody JsonNode jsonNode) {
		System.out.println("jsonNode=" + jsonNode);
		UserLog bean = titaniumeUserLogCache.selectById(jsonNode.get("id").asInt(1));
		if(bean == null){
			bean = new UserLog();
		}
		bean.setUserName("测试");
		bean.setCreateTime(new Date());
		bean.setUserIp("192.168.1.1");
		titaniumeUserLogCache.updateById(bean);
		return bean;
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public UserLog update2(@PathVariable(value = "id") Integer id) {
		UserLog bean = titaniumeUserLogCache.selectById(id);
		if(bean == null){
			bean = new UserLog();
		}
		bean.setUserName("测试");
		bean.setCreateTime(new Date());
		bean.setUserIp("192.168.1.1");
		titaniumeUserLogCache.updateById(bean);
		return bean;
	}
	
	/**
	 * 在springboot-demo-18测试
	 * 
	 */

}