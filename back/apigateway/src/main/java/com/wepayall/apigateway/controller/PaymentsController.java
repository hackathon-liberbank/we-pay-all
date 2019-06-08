package com.wepayall.apigateway.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.wepayall.apigateway.service.PaymentsService;

@Controller
public class PaymentsController implements PaymentsApi {

    @Autowired
    PaymentsService paymentsService;

    @Override
    public ResponseEntity<PaymentInitiationResponse> paymentsPaymentProductPost(String token, String paymentProduct,
            UUID xRequestId, String psUIPAddress, String psUId, String psUIdType, String psUCorporateId,
            String psUCorporateIdType, String tpPRedirectURI, String tpPNokRedirectURI,
            @Valid PaymentInitiationRequest postReqBodyPayments) {

        return paymentsService.paymentsPaymentProductPost(token, paymentProduct, psUIPAddress, xRequestId,
                postReqBodyPayments);
    }

}
