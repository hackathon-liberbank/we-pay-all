package com.wepayall.bankapi.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.wepayall.bankapi.generated.api.FundsConfirmationsApi;
import com.wepayall.bankapi.generated.model.Body;
import com.wepayall.bankapi.generated.model.FundsAvailableResponse;
import com.wepayall.bankapi.service.FoundsConfirmationService;

@Controller
public class FoundsConfirmationController implements FundsConfirmationsApi {

    @Autowired
    FoundsConfirmationService foundsConfirmationService;

    @Override
    public ResponseEntity<FundsAvailableResponse> fundsConfirmationsPost(String token, UUID xRequestId, Body body) {
        // {
        // "cardNumber": "1196931787259904",
        // "account": {
        // "iban": "ES1020480000213004029736",
        // "currency": "EUR"
        // },
        // "payee": "John Marshall",
        // "instructedAmount": {
        // "currency": "EUR",
        // "amount": 1000
        // }
        // }
        return foundsConfirmationService.fundsConfirmationPost(token, xRequestId, body);
    }

}
