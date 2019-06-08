package com.liberbank.apigateway.service;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.http.ResponseEntity;

import com.example.generated.model.PaymentInitiationRequest;
import com.example.generated.model.PaymentInitiationResponse;

public interface PaymentsService {

    ResponseEntity<PaymentInitiationResponse> paymentsPaymentProductPost(String token, @Min(1) Long userID,
            @Min(1) Long eventID, String paymentProduct, String psUIPAddress, UUID xRequestId,
            @Valid PaymentInitiationRequest postReqBodyPayments);

}
