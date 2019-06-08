package com.wepayall.apigateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.generated.api.TokenApi;
import com.wepayall.apigateway.service.TokenService;

@Controller
@CrossOrigin(origins = "*", methods = { RequestMethod.POST })
public class TokenController implements TokenApi {

    @Autowired
    TokenService tokenService;

    @Override
    public ResponseEntity<Void> tokenPost(String code) {
        return tokenService.tokenPost(code);
    }

}
