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
	
	
	/**
	 * 1,测试这个项目需要打开redis-server
	 * 2,打开redis-cli 
	 * 	 查看是否有keys，有就清空 
	 * 	命令: 查看 keys * 
	 * 		  清空 flushdb
	 * 
	 * 3,再次访问http://127.0.0.1:8080/api/select 
	 * 第一次是查不到，所有查数据库
	 * 第二次执行上面的地址，没有查询数据库了，然打开redis客户端数keys * 可以看到一个key 经过序列化缓存进去的
	 */
}
