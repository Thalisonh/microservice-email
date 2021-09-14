package com.ms.email.application.service;

import com.ms.email.application.entities.enums.StatusEmail;
import com.ms.email.application.entities.EmailModel;
import com.ms.email.application.ports.EmailRepository;
import com.ms.email.application.ports.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public class EmailServiceImpl implements EmailService {

    @Autowired
    private final EmailRepository repository;

    @Autowired
    private final JavaMailSender emailSender;

    public EmailServiceImpl(final EmailRepository emailRepository, final JavaMailSender emailSender){
        this.repository = emailRepository;
        this.emailSender = emailSender;
    }

    @Override
    public EmailModel sendEmail(EmailModel model) {
        model.setSendDataEmail(LocalDateTime.now());
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(model.getEmailFrom());
            message.setTo(model.getEmailTo());
            message.setSubject(model.getSubject());
            message.setText(model.getText());
            emailSender.send(message);

            model.setStatusEmail(StatusEmail.SENT);
        }catch (MailException e){
            model.setStatusEmail(StatusEmail.ERROR);
        }finally {
            return repository.save(model);
        }
    }

    @Override
    public Page<EmailModel> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<EmailModel> findById(UUID emailId) {
        return Optional.empty();
    }
}
