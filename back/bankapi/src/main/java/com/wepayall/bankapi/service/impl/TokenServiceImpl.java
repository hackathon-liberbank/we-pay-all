package com.wepayall.bankapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wepayall.bankapi.generated.model.TokenResponse;
import com.wepayall.bankapi.oauth2.TokenOAuth2;
import com.wepayall.bankapi.service.TokenService;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    TokenOAuth2 tokenOauth2;

    @Override
    public ResponseEntity<TokenResponse> getToken(String code) {

        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setToken(tokenOauth2.getAccessTokenFromLiberbankForPayments(code));

        ResponseEntity<TokenResponse> response = new ResponseEntity<>(tokenResponse, HttpStatus.CREATED);

        return response;
    }

}
