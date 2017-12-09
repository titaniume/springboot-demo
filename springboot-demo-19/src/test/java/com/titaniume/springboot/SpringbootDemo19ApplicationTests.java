package com.titaniume.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.titaniume.springboot.component.TitaniumeRedisComponent;

/**
 * 测试readis
 * @author titaniume
 * 2017年12月9日下午11:03:02
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemo19ApplicationTests {
	
	
	//springdata的readis模板
	@Autowired
	private TitaniumeRedisComponent titaniumeRedisComponent;
	
	@Test
	public void set(){
		titaniumeRedisComponent.set("titaniume", "hello readis!");
	}
	
	@Test
	public void get(){
		System.out.println(titaniumeRedisComponent.get("titaniume"));
	}
	
	@Test
	public void delete(){
		titaniumeRedisComponent.delete("titaniume");
	}
	
}
