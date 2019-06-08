package com.liberbank.apigateway.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.liberbank.apigateway.dto.MailRequestDTO;
import com.liberbank.apigateway.service.MailService;

@Service
public class MailSenderImpl implements MailService {

    private final String URL = "http://localhost:8020/mails";

    @Override
    public void senEmailString(String to, String subjet, String body) {
        RestTemplate restTemplate = new RestTemplate();
        MailRequestDTO request = new MailRequestDTO();
        request.setSubject(subjet);
        request.setBody(body);
        request.setTo(to);
        ResponseEntity<Void> response = restTemplate.postForEntity(URL, request, Void.class);

    }

}
