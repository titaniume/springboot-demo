package com.titaniume.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.titaniume.springboot.bean.User;
import com.titaniume.springboot.mapper.UserMapper;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 测试Swagger
 * @author titaniume
 * 2017年12月14日下午2:30:35
 *
 */
@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	private UserMapper userMapper;

	@ApiOperation(value = "查找", notes = "根据用户ID查找用户")   //添加描述
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public User get(@RequestParam(defaultValue = "1") Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}
	
	@ApiIgnore   //忽略暴露的API
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public int delete(@RequestParam(defaultValue = "1") Integer id) {
		return userMapper.deleteByPrimaryKey(id);
	}
}
