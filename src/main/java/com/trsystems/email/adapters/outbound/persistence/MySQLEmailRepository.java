package com.trsystems.email.adapters.outbound.persistence;

import java.util.Optional;
import java.util.UUID;

import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.trsystems.email.application.entities.EmailModel;
import com.trsystems.email.application.ports.EmailRepository;

@Component
@Primary
public class MySQLEmailRepository implements EmailRepository {

    private final SpringDataMySQLEmailRepository emailRepository;

    public MySQLEmailRepository(final SpringDataMySQLEmailRepository orderRepository) {
        this.emailRepository = orderRepository;
    }

    @Override
    public EmailModel save(EmailModel emailModel) {
        return emailRepository.save(emailModel);
    }

    @Override
    public Page<EmailModel> findAll(Pageable pageable) {
        return emailRepository.findAll(pageable);
    }

    @Override
    public Optional<EmailModel> findById(UUID emailId) {
        return emailRepository.findById(emailId);
    }
}
