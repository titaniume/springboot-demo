package com.titaniume.springboot;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import com.titaniume.springboot.component.TitaniumeJmsComponent;
/**
 * 测试JMS-Activemq
 * @author titaniume
 * 2017年12月11日下午3:14:31
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemo23ApplicationTests_1 {

	
	@Autowired
	TitaniumeJmsComponent titaniumeJmsComponent;
	
	@Test
	public void send(){
		titaniumeJmsComponent.send("hello activemq!");
	}
}
