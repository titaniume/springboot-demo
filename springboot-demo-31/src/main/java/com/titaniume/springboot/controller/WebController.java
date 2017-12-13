package com.titaniume.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.titaniume.springboot.bean.User;
import com.titaniume.springboot.mapper.UserMapper;

@RestController
@RequestMapping(value="/web")
public class WebController {
	
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping(value ="index")
	public User getUserById(@RequestParam(defaultValue = "1")Integer id){
		return userMapper.selectByPrimaryKey(id);
	}
}
