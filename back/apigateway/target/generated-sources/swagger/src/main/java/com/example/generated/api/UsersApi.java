/**
 * NOTE: This class is auto generated by the swagger code generator program (2.2.3).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.example.generated.api;

import com.example.generated.model.AccountsGetResponse;
import com.example.generated.model.CreateEventRequest;
import com.example.generated.model.Event;
import com.example.generated.model.MessageResponse;
import com.example.generated.model.UserDataUpdate;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-06-08T02:35:48.848+02:00")

@Api(value = "users", description = "the users API")
public interface UsersApi {

    @ApiOperation(value = "Consultar los datos las cuentas de un usuario", notes = "Consultar los datos las cuentas de un usuario", response = AccountsGetResponse.class, tags={ "Privado", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = AccountsGetResponse.class) })
    
    @RequestMapping(value = "/users/{userID}/accounts",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<AccountsGetResponse> usersUserIDAccountsGet(@ApiParam(value = "" ,required=true) @RequestHeader(value="token", required=true) String token, @Min(1)@ApiParam(value = "",required=true ) @PathVariable("userID") Long userID);


    @ApiOperation(value = "Recuperar la informacion de un evento", notes = "Recuperar la informacion de un evento", response = Event.class, tags={ "Privado", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Event.class) })
    
    @RequestMapping(value = "/users/{userID}/events/{eventID}",
        method = RequestMethod.GET)
    ResponseEntity<Event> usersUserIDEventsEventIDGet(@ApiParam(value = "" ,required=true) @RequestHeader(value="token", required=true) String token, @Min(1)@ApiParam(value = "",required=true ) @PathVariable("userID") Long userID, @Min(1)@ApiParam(value = "",required=true ) @PathVariable("eventID") Long eventID);


    @ApiOperation(value = "Realizar un pago desde la cuenta generada del evento.", notes = "Realizar un pago desde la cuenta generada del evento.", response = Void.class, tags={ "Privado", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Void.class) })
    
    @RequestMapping(value = "/users/{userID}/events/{eventID}/payments",
        method = RequestMethod.POST)
    ResponseEntity<Void> usersUserIDEventsEventIDPaymentsPost(@ApiParam(value = "" ,required=true) @RequestHeader(value="token", required=true) String token, @Min(1)@ApiParam(value = "",required=true ) @PathVariable("userID") Long userID, @Min(1)@ApiParam(value = "",required=true ) @PathVariable("eventID") Long eventID);


    @ApiOperation(value = "Agregar un usuario a un evento", notes = "Agregar un usuario desde su perfil a un evento", response = Void.class, tags={ "Privado", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Void.class) })
    
    @RequestMapping(value = "/users/{userID}/events/{eventID}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> usersUserIDEventsEventIDPost(@ApiParam(value = "" ,required=true) @RequestHeader(value="token", required=true) String token, @Min(1)@ApiParam(value = "",required=true ) @PathVariable("userID") Long userID, @Min(1)@ApiParam(value = "",required=true ) @PathVariable("eventID") Long eventID);


    @ApiOperation(value = "Crea un evento desde el perfil de usuario.", notes = "Crea un evento desde el perfil de usuario.", response = Void.class, tags={ "Privado", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Void.class) })
    
    @RequestMapping(value = "/users/{userID}/events",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> usersUserIDEventsPost(@ApiParam(value = "" ,required=true) @RequestHeader(value="token", required=true) String token, @Min(1)@ApiParam(value = "",required=true ) @PathVariable("userID") Long userID,@ApiParam(value = "" ,required=true )  @Valid @RequestBody CreateEventRequest createEventRequest);


    @ApiOperation(value = "Modificar datos de Usuario.", notes = "Modificar datos de Usuario.", response = MessageResponse.class, tags={ "Privado", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "CREATED", response = MessageResponse.class) })
    
    @RequestMapping(value = "/users/{userID}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<MessageResponse> usersUserIDPut(@ApiParam(value = "" ,required=true) @RequestHeader(value="token", required=true) String token, @Min(1)@ApiParam(value = "",required=true ) @PathVariable("userID") Long userID,@ApiParam(value = "" ,required=true )  @Valid @RequestBody UserDataUpdate userdata);

}
