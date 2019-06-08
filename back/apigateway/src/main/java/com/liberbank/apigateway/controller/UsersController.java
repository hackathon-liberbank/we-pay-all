package com.liberbank.apigateway.controller;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.generated.api.UsersApi;
import com.example.generated.model.AccountsGetResponse;
import com.example.generated.model.CreateEventRequest;
import com.example.generated.model.Event;
import com.example.generated.model.MessageResponse;
import com.example.generated.model.PaymentInitiationRequest;
import com.example.generated.model.PaymentInitiationResponse;
import com.example.generated.model.UserDataUpdate;
import com.liberbank.apigateway.service.PaymentsService;
import com.liberbank.apigateway.service.UserService;

@Controller
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT })
public class UsersController implements UsersApi {

    @Autowired
    UserService service;

    @Autowired
    PaymentsService paymentsService;

    @Override
    public ResponseEntity<AccountsGetResponse> usersUserIDAccountsGet(String token, @Min(1) Long userID) {
        // TODO Auto-generated method stub
        return service.usersUserIDAccountsGet(token, userID);
    }

    @Override
    public ResponseEntity<Event> usersUserIDEventsEventIDGet(String token, @Min(1) Long userID, @Min(1) Long eventID) {
        return service.usersUserIDEventsEventIDGet(token, userID, eventID);
    }

    @Override
    public ResponseEntity<Void> usersUserIDEventsEventIDPost(String token, @Min(1) Long userID, @Min(1) Long eventID) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<MessageResponse> usersUserIDPut(String token, @Min(1) Long userID,
            @Valid UserDataUpdate userdata) {
        return service.usersUserIDPut(token, userID, userdata);
    }

    @Override
    public ResponseEntity<Void> usersUserIDEventsPost(String token, @Min(1) Long userID,
            @Valid CreateEventRequest createEventRequest) {
        return service.usersUserIDEventsPost(token, userID, createEventRequest);
    }

    @Override
    public ResponseEntity<Event> usersUserIDEventsGet(String token, @Min(1) Long userID) {
        // TODO Auto-generated method stub
        return service.usersUserIDEventsGet(token, userID);
    }

    @Override
    public ResponseEntity<PaymentInitiationResponse> usersUserIDEventsEventIDPaymentsPaymentProductPost(
            @Min(1) Long userID, String token, @Min(1) Long eventID, String paymentProduct, UUID xRequestId,
            String psUIPAddress, @Valid PaymentInitiationRequest postReqBodyPayments) {
        return paymentsService.paymentsPaymentProductPost(token, userID, eventID, paymentProduct, psUIPAddress,
                xRequestId, postReqBodyPayments);
    }

}
