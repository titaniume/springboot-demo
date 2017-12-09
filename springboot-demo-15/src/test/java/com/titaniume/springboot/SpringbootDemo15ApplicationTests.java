package com.titaniume.springboot;


import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.titaniume.springboot.bean.User;
import com.titaniume.springboot.dao.UserDao;
import com.titaniume.springboot.util.base.Page;



@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemo15ApplicationTests {
	
	@Autowired
	private UserDao userDao;
	
	@Test
	public void insert() {
		User user = new User();
		user.setName("测试数据");
		user.setCreateTime(new Date());
		int result = userDao.insert(user);
		System.out.println(result);
	}

	@Test
	public void delete(){
		int result = userDao.deleteById(5);
		System.out.println(result);
	}
	
	@Test
	public void update(){
		User user = new User();
		user.setName("lishi");
		user.setCreateTime(new Date());
		user.setId(7);
		int result = userDao.updateById(user);
		System.out.println(result);
	}
	
	
	@Test
	public void selectOne(){
		User user = userDao.selectById(11);
		System.out.println(user);
	}
	
	// 分页测试
	@Test
	public void queryForPage(){
		Page<User> result = userDao.queryForPage(1, 20, "测试");
		System.err.println(result.getList());
	}

	
}
