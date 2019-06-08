/**
 * NOTE: This class is auto generated by the swagger code generator program (2.2.3).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.example.generated.api;

import com.example.generated.model.MessageResponse;
import com.example.generated.model.UserData;

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

@Api(value = "registry", description = "the registry API")
public interface RegistryApi {

    @ApiOperation(value = "Registrar un nuevo usuario.", notes = "Registrar un nuevo usuario.", response = MessageResponse.class, tags={ "Publico", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "CREATED", response = MessageResponse.class) })
    
    @RequestMapping(value = "/registry",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<MessageResponse> registryPost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody UserData userdata);

}
