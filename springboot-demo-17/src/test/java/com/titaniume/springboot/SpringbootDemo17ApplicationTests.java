package com.titaniume.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.titaniume.springboot.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemo17ApplicationTests {

	@Autowired 
	private UserService userService;
	
	/**
	 * 测试事务
	 */
	@Test
	public void register(){
		String result = userService.register("zs", "127.0.0.4");
		System.out.println(result);
	} 
}
