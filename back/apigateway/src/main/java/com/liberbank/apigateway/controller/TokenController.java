package com.liberbank.apigateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.generated.api.TokenApi;
import com.example.generated.model.Token;
import com.liberbank.apigateway.service.TokenService;

@Controller
@CrossOrigin(origins = "*", methods = { RequestMethod.POST })
public class TokenController implements TokenApi {

    @Autowired
    TokenService tokenService;

    @Override
    public ResponseEntity<Token> tokenCodePost(String code) {
        return tokenService.tokenPost(code);
    }

}
