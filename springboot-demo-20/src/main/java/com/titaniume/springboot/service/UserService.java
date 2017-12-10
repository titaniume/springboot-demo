package com.titaniume.springboot.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.titaniume.springboot.bean.User;
import com.titaniume.springboot.bean.UserLog;
import com.titaniume.springboot.dao.UserDao;
import com.titaniume.springboot.dao.UserLogDao;

@Service
public class UserService {
	
	@Autowired
	private  UserDao userDao;
	
	@Autowired
	private UserLogDao userLogDao;
	
	
	/**
	 * 事务处理
	 * @param name
	 * @param ip
	 * @return
	 */
	@Transactional
	public String register(String name,String ip){
		//1.添加用户
		User user = new User();
		user.setName(name);
		user.setCreateTime(new Date());
		userDao.insert(user);
		
		//测试使用
		boolean flag =true;
		if(flag){
			throw new RuntimeException();
		}
		
		//2.添加注册日志
		UserLog userlog = new UserLog();
		userlog.setUserName(name);
		userlog.setUserIp("127.0.0.1");
		userlog.setCreateTime(new Date());
		userLogDao.save(userlog);
		return "success";
		
	}
}
