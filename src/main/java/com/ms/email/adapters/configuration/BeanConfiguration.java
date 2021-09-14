package com.ms.email.adapters.configuration;

import com.ms.email.EmailApplication;
import com.ms.email.application.ports.EmailRepository;
import com.ms.email.application.service.EmailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
@ComponentScan(basePackageClasses = EmailApplication.class)
public class BeanConfiguration {

    @Bean
    EmailServiceImpl emailServiceImpl(EmailRepository repository, JavaMailSender emailSender){
        return new EmailServiceImpl(repository, emailSender);
    }
}
