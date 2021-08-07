package com.trsystems.api.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.trsystems.api.dtos.EmailDTO;
import com.trsystems.api.models.Email;
import com.trsystems.api.services.EmailService;

// Classe que escuta a fila

@Component
public class EmailConsumer {

	@Autowired
	private EmailService emailService;
	
	// Método ouvinte
	@RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload EmailDTO emailDto) {
		Email email = new Email();
        BeanUtils.copyProperties(emailDto, email);
        emailService.sendEmail(email);
        System.out.println("Email Status: " + email.getStatusEmail().toString());
    }
}
