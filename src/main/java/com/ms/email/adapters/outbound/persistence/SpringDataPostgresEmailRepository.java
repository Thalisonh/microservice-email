package com.ms.email.adapters.outbound.persistence;

import com.ms.email.application.entities.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringDataPostgresEmailRepository extends JpaRepository<EmailModel, UUID> {
}
