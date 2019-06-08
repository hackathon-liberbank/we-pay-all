package com.wepayall.bankapi.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.wepayall.bankapi.generated.api.PaymentsApi;
import com.wepayall.bankapi.generated.model.PaymentInitiationRequest;
import com.wepayall.bankapi.generated.model.PaymentInitiationResponse;
import com.wepayall.bankapi.generated.model.PaymentResponse;
import com.wepayall.bankapi.service.PaymentsService;

@Controller
public class PaymentsController implements PaymentsApi {

    @Autowired
    PaymentsService paymentsService;

    /**
     * usar con este postReqBodyParameters { "endToEndIdentification": "3456345623457", "debtorAccount": { "iban":
     * "ES0000000000000000000000", "currency": "EUR" }, "instructedAmount": { "currency": "EUR", "amount": 10 },
     * "creditorAccount": { "iban": "ES0000000000000000000000", "currency": "EUR" }, "creditorAgent": "337562046",
     * "creditorName": "Pedro García Hidalgo", "creditorAddress": { "street": "Fuente de la mora", "buildingNumber": "2",
     * "city": "Madrid", "postalCode": "28050", "countryCode": "ESP" }, "remittanceInformationUnstructured":
     * "ufaajitaweromlubomunugodsahbipulafueguukibugbakagofnuuzowenesigakfezsurevaglohupilozjuvevsamvozanagrahu",
     * "requestedExecutionDate": "2017-07-21" }
     */
    @Override
    public ResponseEntity<PaymentResponse> paymentsPaymentProductPaymentIdGet(String token, String paymentProduct,
            String paymentId, String psUIPAddress, String xRequestId, String psUId, String psUIdType,
            String psUCorporateId, String psUCorporateIDType, String tpPRedirectURI, String tpPNokRedirectURI) {
        return paymentsService.paymentsPaymentProductPaymentIdGet(token, psUIPAddress, xRequestId);
    }

    @Override
    public ResponseEntity<PaymentInitiationResponse> paymentsPaymentProductPost(String token, String paymentProduct,
            UUID xRequestId, String psUIPAddress, String psUId, String psUIdType, String psUCorporateId,
            String psUCorporateIdType, String tpPRedirectURI, String tpPNokRedirectURI,
            @Valid PaymentInitiationRequest postReqBodyPayments) {
        return paymentsService.paymentsPaymentProductPost(token, paymentProduct, psUIPAddress, xRequestId,
                postReqBodyPayments);
    }

}
