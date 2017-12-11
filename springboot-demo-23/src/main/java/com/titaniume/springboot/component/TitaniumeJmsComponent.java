package com.titaniume.springboot.component;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;
/**
 * 发送/接收消息 处理
 * @author titaniume
 * 2017年12月11日下午3:12:42
 *
 */
@Component
public class TitaniumeJmsComponent {

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;
	
	@Autowired
	private Queue queue;

	public void send(String msg) {
		this.jmsMessagingTemplate.convertAndSend(this.queue, msg);
	}
	
	@JmsListener(destination = "titaniume.queue")
	public void receiveQueue(String text) {
		System.out.println("接受到：" + text);
	}

}