package com.trsystems.email.application.ports;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.trsystems.email.application.entities.EmailModel;

public interface EmailService {

    EmailModel sendEmail(EmailModel emailModel);
    Page<EmailModel> findAll(Pageable pageable);
    Optional<EmailModel> findById(UUID emailId);
}
