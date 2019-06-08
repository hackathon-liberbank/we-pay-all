package com.liberbank.apigateway.service;

public interface BlockchainService {

    public void sendTransaction(Long amount, Long eventID, Long beneficiary);

}
