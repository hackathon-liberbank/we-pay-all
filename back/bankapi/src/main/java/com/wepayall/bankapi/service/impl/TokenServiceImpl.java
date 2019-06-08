package com.wepayall.bankapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wepayall.bankapi.oauth2.TokenOAuth2;
import com.wepayall.bankapi.service.TokenService;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    TokenOAuth2 tokenOauth2;

    @Override
    public ResponseEntity<Void> getToken(String code) {

        HttpHeaders headersRespose = new HttpHeaders();
        headersRespose.add("token", tokenOauth2.getAccessTokenFromLiberbankForPayments(code));

        ResponseEntity<Void> response = new ResponseEntity<>(headersRespose, HttpStatus.CREATED);

        return response;
    }

}
