package com.liberbank.apigateway.service;

import org.springframework.http.ResponseEntity;

import com.example.generated.model.Token;

public interface TokenService {

    ResponseEntity<Token> tokenPost(String code);

}
