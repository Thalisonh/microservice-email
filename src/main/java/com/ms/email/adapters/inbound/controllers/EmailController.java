package com.ms.email.adapters.inbound.controllers;

import com.ms.email.adapters.inbound.dtos.EmailDTO;
import com.ms.email.application.entities.EmailModel;
import com.ms.email.application.service.EmailServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class EmailController {

    @Autowired
    private EmailServiceImpl service;

    @PostMapping("/sending-email")
    public ResponseEntity<EmailModel> sendingEmail(@RequestBody @Valid EmailDTO dto){
        EmailModel model = new EmailModel();
        BeanUtils.copyProperties(dto, model);

        service.sendEmail(model);

        return new ResponseEntity<>(model, HttpStatus.CREATED);
    }
}
