package com.liberbank.apigateway.service;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.example.generated.model.PaymentInitiationRequest;
import com.example.generated.model.PaymentInitiationResponse;

public interface PaymentsService {

    ResponseEntity<PaymentInitiationResponse> paymentsPaymentProductPost(String token, String paymentProduct,
            String psUIPAddress, UUID xRequestId, @Valid PaymentInitiationRequest postReqBodyPayments);

}
