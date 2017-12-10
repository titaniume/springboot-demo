package com.titaniume.springboot;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.titaniume.springboot.bean.UserLog;
import com.titaniume.springboot.dao.UserLogDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemo18ApplicationTests {


	@Autowired
	private UserLogDao userLogDao;
	
	//JpaRepository 接口自带的查询
	@Test
	public void insert() {
		UserLog user = new UserLog();
		user.setUserName("titaniume2");
		user.setUserIp("127.0.0.1");
		user.setCreateTime(new Date());
		userLogDao.save(user);
	}

	@Test
	public void delete() {
		userLogDao.delete(2);
	}

	@Test
	public void update() {
		UserLog user = new UserLog();
		user.setId(3);
		user.setUserName("titaniume2");
		user.setUserIp("192.168.0.1");
		user.setCreateTime(new Date());
		userLogDao.save(user);
	}

	@Test
	public void select1() {
		UserLog result = userLogDao.findOne(1);
		System.out.println(result);
	}
}
