package com.liberbank.apigateway.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.example.generated.api.PaymentsApi;
import com.example.generated.model.PaymentInitiationRequest;
import com.example.generated.model.PaymentInitiationResponse;
import com.liberbank.apigateway.service.PaymentsService;

@Controller
public class PaymentsController implements PaymentsApi {

    @Autowired
    PaymentsService paymentsService;

    @Override
    public ResponseEntity<PaymentInitiationResponse> paymentsPaymentProductPost(String token, String paymentProduct,
            UUID xRequestId, String psUIPAddress, @Valid PaymentInitiationRequest postReqBodyPayments) {
        // return paymentsService.paymentsPaymentProductPost(token, paymentProduct, psUIPAddress, xRequestId,
        // postReqBodyPayments);
        return null;
    }

}
