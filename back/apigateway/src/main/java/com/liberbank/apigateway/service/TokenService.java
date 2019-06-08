package com.liberbank.apigateway.service;

import org.springframework.http.ResponseEntity;

public interface TokenService {

    ResponseEntity<Void> tokenPost(String code);

}
