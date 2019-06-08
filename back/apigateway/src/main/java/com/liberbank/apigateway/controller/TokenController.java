package com.liberbank.apigateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.generated.api.TokenApi;

@Controller
@CrossOrigin(origins = "*", methods = { RequestMethod.POST })
public class TokenController implements TokenApi {

    @Override
    public ResponseEntity<Void> tokenPost(String code) {
        return null;
    }

}
