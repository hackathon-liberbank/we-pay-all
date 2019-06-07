package com.wepayall.bankapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.wepayall.bankapi.generated.api.TokenApi;
import com.wepayall.bankapi.generated.model.TokenResponse;
import com.wepayall.bankapi.service.TokenService;

@Controller
public class TokenController implements TokenApi {

    @Autowired
    TokenService tokenService;

    @Override
    public ResponseEntity<TokenResponse> tokenPost(String code) {
        return tokenService.getToken(code);
    }

}
