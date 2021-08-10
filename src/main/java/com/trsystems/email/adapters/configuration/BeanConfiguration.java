package com.trsystems.email.adapters.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

import com.trsystems.email.MsEnvioEmailApplication;
import com.trsystems.email.application.ports.EmailRepository;
import com.trsystems.email.application.services.EmailServiceImpl;

@Configuration
@ComponentScan(basePackageClasses = MsEnvioEmailApplication.class)
public class BeanConfiguration {

    @Bean
    EmailServiceImpl emailServiceImpl(EmailRepository repository, JavaMailSender emailSender) {
        return new EmailServiceImpl(repository, emailSender);
    }
}
