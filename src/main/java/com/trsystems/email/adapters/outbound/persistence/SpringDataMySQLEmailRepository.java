package com.trsystems.email.adapters.outbound.persistence;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trsystems.email.application.entities.EmailModel;

@Repository
public interface SpringDataMySQLEmailRepository extends JpaRepository<EmailModel, UUID> {
}
