package com.titaniume.springboot;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.titaniume.springboot.controller.IndexController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemo2ApplicationTests {
	
	private MockMvc mvc;
	
	
	@Before
	public void before(){
		this.mvc=MockMvcBuilders.standaloneSetup(new IndexController()).build();
	}
	
	@Test
	public void contextLoads() throws Exception {
		RequestBuilder req = get("/index");
		mvc.perform(req).andExpect(status().isOk()).andExpect(content().string("hello world!"));
	}

}
