package com.liberbank.apigateway.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import com.example.generated.model.User;
import com.example.generated.model.UserDataUpdate;
import com.liberbank.apigateway.dao.EventDAO;
import com.liberbank.apigateway.dao.UserDAO;
import com.liberbank.apigateway.exceptions.EventRepositoryException;
import com.liberbank.apigateway.exceptions.UserRepositoryException;
import com.liberbank.apigateway.repository.EventRepository;
import com.liberbank.apigateway.repository.UserRpository;
import com.liberbank.apigateway.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private static final Log log = LogFactory.getLog(UserServiceImpl.class);

    @Autowired
    UserRpository userRepository;

    @Autowired
    EventRepository eventRepository;

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
        // TODO Auto-generated method stub
        return null;
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
