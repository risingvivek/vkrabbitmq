package com.quasys.vkrabbimq.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.quasys.vkrabbimq.model.Employee;

@Service
public class RabbitMQSender {
	
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Value("${vk.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${vk.rabbitmq.routingkey}")
	private String routingkey;	
	
	public void send(Employee employeeDetails) {
		rabbitTemplate.convertAndSend(exchange, routingkey, employeeDetails);
		System.out.println("Send msg = " + employeeDetails);
	    
	}

}
