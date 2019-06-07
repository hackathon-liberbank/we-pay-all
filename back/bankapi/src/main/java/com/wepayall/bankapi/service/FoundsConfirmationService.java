package com.wepayall.bankapi.service;

import java.util.UUID;

import org.springframework.http.ResponseEntity;

import com.wepayall.bankapi.generated.model.Body;
import com.wepayall.bankapi.generated.model.FundsAvailableResponse;

public interface FoundsConfirmationService {

    ResponseEntity<FundsAvailableResponse> fundsConfirmationPost(String code, UUID xRequestID, Body body);

}
