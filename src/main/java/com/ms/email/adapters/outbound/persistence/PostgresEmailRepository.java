package com.ms.email.adapters.outbound.persistence;

import com.ms.email.application.entities.EmailModel;
import com.ms.email.application.ports.EmailRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@Primary
public class PostgresEmailRepository implements EmailRepository {

    private final SpringDataPostgresEmailRepository emailRepository;

    public PostgresEmailRepository(final SpringDataPostgresEmailRepository orderRespository){
        this.emailRepository = orderRespository;
    }

    @Override
    public EmailModel save(EmailModel emailModel){
        return emailRepository.save(emailModel);
    }

    @Override
    public Page<EmailModel> findAll(Pageable pageable){
        return emailRepository.findAll(pageable);
    }

    @Override
    public Optional<EmailModel> findById(UUID emailId){
        return emailRepository.findById(emailId);
    }
}
