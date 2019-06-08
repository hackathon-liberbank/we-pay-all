package com.wepayall.bankapi.service;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.wepayall.bankapi.generated.model.PaymentInitiationRequest;
import com.wepayall.bankapi.generated.model.PaymentInitiationResponse;
import com.wepayall.bankapi.generated.model.PaymentResponse;

public interface PaymentsService {

    ResponseEntity<PaymentInitiationResponse> paymentsPaymentProductPost(String token, String paymentProduct,
            String psUIPAddress, UUID xRequestId, @Valid PaymentInitiationRequest postReqBodyPayments);

    ResponseEntity<PaymentResponse> paymentsPaymentProductPaymentIdGet(String token, String psUIPAddress,
            String xRequestId);

}
