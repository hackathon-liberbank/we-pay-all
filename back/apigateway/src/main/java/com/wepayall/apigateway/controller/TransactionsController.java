package com.wepayall.apigateway.controller;

import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.generated.api.TransactionsApi;
import com.example.generated.model.TransactionResponse;
import com.wepayall.apigateway.service.TransactionsService;

@Controller
@CrossOrigin(origins = "*", methods = { RequestMethod.GET })
public class TransactionsController implements TransactionsApi {

    @Autowired
    TransactionsService service;

    @Override
    public ResponseEntity<TransactionResponse> transactionsTransactionHashGet(String token,
            @Size(min = 60, max = 70) String transactionHash) {
        // TODO Auto-generated method stub
        return null;
    }

}
