package com.titaniume.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;

@ServletComponentScan
@SpringBootApplication
@ImportResource(locations = {"classpath:druid-bean.xml"})
public class SpringbootDemo31Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemo31Application.class, args);
	}
}
