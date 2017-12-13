package com.titaniume.springboot;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.titaniume.springboot.bean.User;
import com.titaniume.springboot.mapper.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemo29ApplicationTests {

	@Autowired
	private UserMapper mapper;

	@Test
	public void insert() {
		User user = new User();
		user.setName("测试1");
		user.setCreateTime(new Date());
		int result = mapper.insert(user);
		System.out.println(result);
	}

}
