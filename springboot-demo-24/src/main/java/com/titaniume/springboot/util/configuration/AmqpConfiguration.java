package com.titaniume.springboot.util.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * amqp 队列设置
 * @author titaniume
 * 2017年12月11日下午10:14:32
 *
 */
@Configuration
public class AmqpConfiguration {

	@Bean
	public Queue queue() {
		return new Queue("titaniume.queue");
	}

}