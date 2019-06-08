package com.wepayall.apigateway.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.generated.model.TransactionResponse;
import com.wepayall.apigateway.dao.UserDAO;
import com.wepayall.apigateway.dto.TransactionDTO;
import com.wepayall.apigateway.exceptions.UserRepositoryException;
import com.wepayall.apigateway.repository.UserRpository;
import com.wepayall.apigateway.service.TransactionsService;

@Service
public class TransactionsServiceImpl implements TransactionsService {

    private static String BLOCKCHAIN_URL = "http://localhost:8070/transactions/";

    @Autowired
    UserRpository userRepository;

    @Override
    public ResponseEntity<TransactionResponse> transactionsTransactionHashGet(String transactionHash) {
        RestTemplate restTemplate = new RestTemplate();

        TransactionDTO dto = restTemplate.getForObject(BLOCKCHAIN_URL + transactionHash, TransactionDTO.class);

        UserDAO devitor = userRepository.findById(dto.getDebitorID())
                .orElseThrow(() -> new UserRepositoryException("No se ha recuperado el remitente de la transacion"));

        UserDAO creditor = userRepository.findById(dto.getCreditorID().longValue())
                .orElseThrow(() -> new UserRepositoryException("No se ha recuperado el receptor de la transacion"));

        TransactionResponse response = new TransactionResponse();
        // response.setEvent(DataUtils.userDAOToUser(devitor).getName());
        // response.setCreditor(DataUtils.userDAOToUser(creditor));
        // response.setAmmount(dto.getAmount());

        return new ResponseEntity<TransactionResponse>(response, HttpStatus.OK);
    }

}
