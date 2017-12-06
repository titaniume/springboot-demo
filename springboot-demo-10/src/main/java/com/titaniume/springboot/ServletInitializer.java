package com.titaniume.springboot;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 这个类是自动创建的相当于web.xml
 * @author titaniume
 * 2017年12月7日上午1:44:55
 *
 */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringbootDemo10Application.class);
	}

}
