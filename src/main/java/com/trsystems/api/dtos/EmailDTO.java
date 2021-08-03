package com.trsystems.api.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class EmailDTO {

	@NotBlank
	private String ownerRef;
	
	@NotBlank
	@Email
	private String emailFrom;
	
	@NotBlank
	@Email
	private String emailTo;
	
	@NotBlank
	private String subject; // title email
	
	@NotBlank
	private String text;
}
