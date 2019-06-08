package com.liberbank.apigateway.service.impl;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.generated.model.PaymentInitiationRequest;
import com.example.generated.model.PaymentInitiationResponse;
import com.liberbank.apigateway.service.PaymentsService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PaymentsServiceImpl implements PaymentsService {

    @Value("${bankapi.host}")
    String bankApiHost;

    @Value("${bankapi.port}")
    String bankApiPort;

    /**
     * usar este postReqBodyPayments { "endToEndIdentification": "3456345623457", "debtorAccount": { "iban":
     * "ES0000000000000000000000", "currency": "EUR" }, "instructedAmount": { "currency": "EUR", "amount": 10 },
     * "creditorAccount": { "iban": "ES0000000000000000000000", "currency": "EUR" }, "creditorAgent": "337562046",
     * "creditorName": "Pedro García Hidalgo", "creditorAddress": { "street": "Fuente de la mora", "buildingNumber": "2",
     * "city": "Madrid", "postalCode": "28050", "countryCode": "ESP" }, "remittanceInformationUnstructured":
     * "ufaajitaweromlubomunugodsahbipulafueguukibugbakagofnuuzowenesigakfezsurevaglohupilozjuvevsamvozanagrahu",
     * "requestedExecutionDate": "2017-07-21" }
     */
    @Override
    public ResponseEntity<PaymentInitiationResponse> paymentsPaymentProductPost(String token, String paymentProduct,
            String psUIPAddress, UUID xRequestId, @Valid PaymentInitiationRequest postReqBodyPayments) {

        RestTemplate restTemplate;
        HttpEntity<PaymentInitiationRequest> request;
        ResponseEntity<PaymentInitiationResponse> response = null;
        ResponseEntity<PaymentInitiationResponse> responseRequest = null;

        restTemplate = new RestTemplate();

        HttpHeaders headers = getBankapiHeaders();
        headers.add("token", token);
        headers.add("X-Request-Id", xRequestId.toString());
        headers.add("PSU-IP-Address", psUIPAddress);

        request = new HttpEntity<>(postReqBodyPayments, headers);

        String bankApiurl = new StringBuilder().append("http://").append(bankApiHost).append(":").append(bankApiPort)
                .append("/payments/").append(paymentProduct).toString();

        String uri = UriComponentsBuilder.fromHttpUrl(bankApiurl).toUriString();

        try {
            response = restTemplate.postForEntity(uri, request, PaymentInitiationResponse.class);
        } catch (final HttpClientErrorException e) {
            log.info(e.getStatusCode().toString());
            log.info(e.getResponseBodyAsString());
        }

        if (response != null && response.getStatusCode() == HttpStatus.CREATED) {
            responseRequest = response;
        }

        return responseRequest;
    }

    private HttpHeaders getBankapiHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-type", "application/json");
        headers.add("accept", "application/json");

        return headers;
    }

}
