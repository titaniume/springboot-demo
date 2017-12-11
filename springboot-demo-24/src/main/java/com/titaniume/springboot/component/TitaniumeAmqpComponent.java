package com.titaniume.springboot.component;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * 发送/接收 消息处理
 * @author titaniume
 * 2017年12月11日下午10:13:28
 *
 */
@Component
public class TitaniumeAmqpComponent {

	@Autowired
	private AmqpTemplate amqpTemplate;

	public void send(String msg) {
		this.amqpTemplate.convertAndSend("titaniume.queue", msg);
	}

	@RabbitListener(queues = "titaniume.queue")
	public void receiveQueue(String text) {
		System.out.println("接受到：" + text);
	}

}