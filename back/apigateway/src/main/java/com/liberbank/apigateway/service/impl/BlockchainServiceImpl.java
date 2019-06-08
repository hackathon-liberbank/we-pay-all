package com.liberbank.apigateway.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.liberbank.apigateway.dto.PaymentResponseBlockChainDTO;
import com.liberbank.apigateway.service.BlockchainService;

@Service
public class BlockchainServiceImpl implements BlockchainService {

    private static final String URL = "http://localhost:8070/payments/";

    @Override
    public void sendTransaction(Long amount, Long eventID, Long beneficiary) {
        RestTemplate restTemplate = new RestTemplate();
        PaymentResponseBlockChainDTO response = restTemplate.getForObject(URL + 1, PaymentResponseBlockChainDTO.class);
        System.out.println(response);
    }

}
