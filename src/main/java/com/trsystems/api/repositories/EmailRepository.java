package com.trsystems.api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trsystems.api.models.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, UUID>{

}
