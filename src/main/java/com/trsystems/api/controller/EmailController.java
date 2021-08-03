package com.trsystems.api.controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trsystems.api.dtos.EmailDTO;
import com.trsystems.api.models.Email;
import com.trsystems.api.services.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {

	@Autowired
	private EmailService emailService;
	
	@PostMapping("/sending")
	public ResponseEntity<Email> sendingEmail(@RequestBody @Valid EmailDTO emailDTO) {
		Email email = new Email();
		BeanUtils.copyProperties(emailDTO, email);
		emailService.sendEmail(email);
		return new ResponseEntity<>(email, HttpStatus.CREATED);
	}
}
