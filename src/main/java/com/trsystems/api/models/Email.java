package com.trsystems.api.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.trsystems.api.enums.StatusEmail;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_EMAIL")
public class Email implements Serializable {
	private static final long serialVersionUID = 2163470903171693587L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ownerRef;
	private String emailFrom;
	private String emailTo;
	private String subject; // title email

	@Column(columnDefinition = "TEXT") // without limitation
	private String text;

	private LocalDateTime sendDateEmail;
	private StatusEmail statusEmail;
}
