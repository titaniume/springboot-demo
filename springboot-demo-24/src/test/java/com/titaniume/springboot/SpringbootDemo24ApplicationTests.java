package com.titaniume.springboot;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.titaniume.springboot.component.TitaniumeAmqpComponent;



/**
 * 测试 rabbitmq
 * @author titaniume
 * 2017年12月11日下午5:27:12
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemo24ApplicationTests {

	@Autowired
	private TitaniumeAmqpComponent titaniumeAmqpComponent;

	@Test
	public void send() {
		titaniumeAmqpComponent.send("hello rabbitmq!");
	}
	
}
