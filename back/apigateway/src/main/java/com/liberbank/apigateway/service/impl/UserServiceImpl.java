package com.liberbank.apigateway.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.generated.model.AccountsGetResponse;
import com.example.generated.model.CreateEventRequest;
import com.example.generated.model.Event;
import com.example.generated.model.MessageResponse;
import com.example.generated.model.PaymentInitiationRequest;
import com.example.generated.model.PaymentInitiationResponse;
import com.example.generated.model.User;
import com.example.generated.model.UserDataUpdate;
import com.google.gson.Gson;
import com.liberbank.apigateway.dao.EventDAO;
import com.liberbank.apigateway.dao.UserDAO;
import com.liberbank.apigateway.exceptions.EventRepositoryException;
import com.liberbank.apigateway.exceptions.UserRepositoryException;
import com.liberbank.apigateway.repository.EventRepository;
import com.liberbank.apigateway.repository.UserRpository;
import com.liberbank.apigateway.service.PaymentsService;
import com.liberbank.apigateway.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private static final Log log = LogFactory.getLog(UserServiceImpl.class);

    @Autowired
    UserRpository userRepository;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    PaymentsService paymentsService;

    @Override
    public ResponseEntity<AccountsGetResponse> usersUserIDAccountsGet(String token, @Min(1) Long userID) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<Event> usersUserIDEventsEventIDGet(String token, @Min(1) Long userID, @Min(1) Long eventID) {
        EventDAO event = eventRepository.findById(eventID)
                .orElseThrow(() -> new EventRepositoryException("Evento no Encontrado"));

        Event response = new Event();
        List<User> users = new ArrayList<User>();
        event.getUsers().forEach(i -> {
            User user = new User();
            user.setName(i.getName());
            user.setSurname(i.getSurname());
            users.add(user);
        });

        response.setDescription(event.getDescription());
        response.setIban("003400000514562365814785");
        response.setPrice(event.getPrice());
        response.setUsers(users);
        response.setName(event.getName());
        return new ResponseEntity<Event>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> usersUserIDEventsEventIDPaymentsPost(String token, @Min(1) Long userID,
            @Min(1) Long eventID) {

        String jsonPaymentData = "{\r\n  \"creditorAccount\": {\r\n    \"currency\": \"EUR\",\r\n    \"iban\": \"ES1720480000003400138578\"\r\n  },\r\n  \"creditorAddress\": {\r\n    \"buildingNumber\": \"2\",\r\n    \"city\": \"Madrid\",\r\n    \"countryCode\": \"ESP\",\r\n    \"postalCode\": \"28050\",\r\n    \"street\": \"Fuente de la mora\"\r\n  },\r\n  \"creditorAgent\": \"337562046\",\r\n  \"creditorName\": \"Pedro Garc\u00EDa Hidalgo\",\r\n  \"debtorAccount\": {\r\n    \"currency\": \"EUR\",\r\n    \"iban\": \"ES1720480000003400138578\"\r\n  },\r\n  \"endToEndIdentification\": \"3456345623457\",\r\n  \"eventID\": 0,\r\n  \"instructedAmount\": {\r\n    \"amount\": 0,\r\n    \"currency\": \"EUR\"\r\n  },\r\n  \"remittanceInformationUnstructured\": \"string\",\r\n  \"requestedExecutionDate\": \"2017-07-21\",\r\n  \"userID\": 0\r\n}";

        PaymentInitiationRequest postReqBodyPayments = new Gson().fromJson(jsonPaymentData,
                PaymentInitiationRequest.class);

        ResponseEntity<PaymentInitiationResponse> response = paymentsService.paymentsPaymentProductPost(token, userID,
                eventID, "sepa-credit-transfers", "192.168.200.100", UUID.randomUUID(), postReqBodyPayments);

        ResponseEntity<Void> paymentResponse = null;
        if (response != null && response.getStatusCode() == HttpStatus.CREATED) {
            paymentResponse = new ResponseEntity<>(HttpStatus.CREATED);
        }

        return paymentResponse;
    }

    @Override
    public ResponseEntity<Void> usersUserIDEventsEventIDPost(String token, @Min(1) Long userID, @Min(1) Long eventID) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<MessageResponse> usersUserIDPut(String token, @Min(1) Long userID,
            @Valid UserDataUpdate userdata) {
        UserDAO user = userRepository.findById(userID)
                .orElseThrow(() -> new UserRepositoryException("Usuario no Encontrado"));
        user.setPhone(userdata.getPhone());
        try {
            userRepository.save(user);
        } catch (Exception e) {
            throw new UserRepositoryException("Usuario no actualizado debido a :" + e.getMessage());
        }
        MessageResponse response = new MessageResponse();
        response.setHttpStatus(200);
        response.setReasonPhrase(HttpStatus.OK.getReasonPhrase());
        response.setMessage(
                "El usuario " + user.getName() + " " + user.getSurname() + " se ha actualizado correctamente");
        return new ResponseEntity<MessageResponse>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> usersUserIDEventsPost(String token, @Min(1) Long userID,
            @Valid CreateEventRequest createEventRequest) {

        UserDAO user = userRepository.findById(userID)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with -> id : " + userID));

        Set<UserDAO> users = new HashSet<UserDAO>();
        users.add(user);

        EventDAO event = new EventDAO();
        event.setDescription(createEventRequest.getDescription());
        event.setPrice(createEventRequest.getPrice());
        event.setUsers(users);
        event.setName(createEventRequest.getName());
        try {
            eventRepository.save(event);
        } catch (Exception e) {
            throw new EventRepositoryException("El evento no se ha registrado : " + e.getMessage());
        }
        user.getEvents().add(event);
        try {
            userRepository.save(user);

        } catch (Exception e) {
            throw new UserRepositoryException(
                    "no se ha podido actualizar el usuario con los datos del evento : " + e.getMessage());
        }
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Event> usersUserIDEventsGet(String token, @Min(1) Long userID) {
        UserDAO user = userRepository.findById(userID)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with -> id : " + userID));

        Event response = new Event();
        List<EventDAO> events = new ArrayList<EventDAO>();
        user.getEvents().forEach(i -> {
            EventDAO e = new EventDAO();
            e.setName(i.getName());
            e.setPrice(i.getPrice());
            e.setDescription(i.getDescription());
            e.setUsers(i.getUsers());
            events.add(e);
        });
        List<User> users = new ArrayList<User>();
        events.get(0).getUsers().forEach(i -> {
            User u = new User();
            u.setName(i.getName());
            u.setSurname(i.getSurname());
            users.add(u);
        });
        response.setDescription(events.get(0).getDescription());
        response.setIban("003400000514562365814785");
        response.setPrice(events.get(0).getPrice());
        response.setUsers(users);
        response.setName(events.get(0).getName());
        return new ResponseEntity<Event>(response, HttpStatus.OK);
    }

}
