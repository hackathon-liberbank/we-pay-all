package com.wepayall.bankapi.service;

import org.springframework.http.ResponseEntity;

import com.wepayall.bankapi.generated.model.TokenResponse;

public interface TokenService {

    ResponseEntity<TokenResponse> getToken(String code);

}
