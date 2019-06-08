package com.liberbank.apigateway.service;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.http.ResponseEntity;

import com.example.generated.model.AccountsGetResponse;
import com.example.generated.model.CreateEventRequest;
import com.example.generated.model.Event;
import com.example.generated.model.MessageResponse;
import com.example.generated.model.UserDataUpdate;

public interface UserService {

    public ResponseEntity<AccountsGetResponse> usersUserIDAccountsGet(String token, @Min(1) Long userID);

    public ResponseEntity<Event> usersUserIDEventsEventIDGet(String token, @Min(1) Long userID, @Min(1) Long eventID);

    public ResponseEntity<Void> usersUserIDEventsEventIDPaymentsPost(String token, @Min(1) Long userID,
            @Min(1) Long eventID);

    public ResponseEntity<Void> usersUserIDEventsEventIDPost(String token, @Min(1) Long userID, @Min(1) Long eventID);

    public ResponseEntity<MessageResponse> usersUserIDPut(String token, @Min(1) Long userID,
            @Valid UserDataUpdate userdata);

    public ResponseEntity<Void> usersUserIDEventsPost(String token, @Min(1) Long userID,
            @Valid CreateEventRequest createEventRequest);

    public ResponseEntity<Event> usersUserIDEventsGet(String token, @Min(1) Long userID);
}
