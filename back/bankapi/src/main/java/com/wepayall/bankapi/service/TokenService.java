package com.wepayall.bankapi.service;

import org.springframework.http.ResponseEntity;

public interface TokenService {

    ResponseEntity<Void> getToken(String code);

}
