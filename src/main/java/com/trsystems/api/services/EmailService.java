package com.trsystems.api.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.trsystems.api.enums.StatusEmail;
import com.trsystems.api.models.Email;
import com.trsystems.api.repositories.EmailRepository;

@Service
public class EmailService {

	@Autowired
	private EmailRepository emailRepository;

	@Autowired
	private JavaMailSender javaMailSender;

	public Email sendEmail(Email email) {
		email.setSendDateEmail(LocalDateTime.now());
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(email.getEmailFrom());
			message.setTo(email.getEmailTo());
			message.setSubject(email.getSubject());
			message.setText(email.getText());

			javaMailSender.send(message);
			email.setStatusEmail(StatusEmail.SENT);
		} catch (Exception e) {
			email.setStatusEmail(StatusEmail.ERROR);
			e.printStackTrace();
		} finally {
			emailRepository.save(email);
		}
		return email;
	}

}
