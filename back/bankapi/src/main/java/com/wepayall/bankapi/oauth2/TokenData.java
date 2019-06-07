package com.wepayall.bankapi.oauth2;

import org.springframework.stereotype.Component;

import com.wepayall.bankapi.properties.LiberbankOauth2Properties;

import lombok.Data;

@Component
@Data
public class TokenData {

    String identification;

    String apiToken;

    String username;

    String password;

    String clientId;

    String clientSecret;

    String redirectUrl;

    public TokenData(LiberbankOauth2Properties properties) {
        identification = properties.getIdentification();
        apiToken = properties.getApiToken();
        username = properties.getUsername();
        password = properties.getPassword();
        clientId = properties.getClientId();
        clientSecret = properties.getClientSecret();
        redirectUrl = properties.getRedirectUrl();
    }
}
