package com.wepayall.apigateway.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.wepayall.apigateway.service.TokenService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TokenServiceImpl implements TokenService {

    @Value("${bankapi.host}")
    String bankApiHost;

    @Value("${bankapi.port}")
    String bankApiPort;

    @Override
    public ResponseEntity<Void> tokenPost(String code) {
        RestTemplate restTemplate;
        HttpEntity<MultiValueMap<String, String>> request;
        ResponseEntity<Void> response = null;
        String accessTokenFromLiberbank = null;

        restTemplate = new RestTemplate();

        HttpHeaders headers = getBankapiHeaders();
        headers.add("code", code);

        request = new HttpEntity<>(headers);

        String bankApiurl = new StringBuilder().append("http://").append(bankApiHost).append(":").append(bankApiPort)
                .append("/token").toString();

        String uri = UriComponentsBuilder.fromHttpUrl(bankApiurl).toUriString();

        try {
            response = restTemplate.postForEntity(uri, request, Void.class);
        } catch (final HttpClientErrorException e) {
            log.info(e.getStatusCode().toString());
            log.info(e.getResponseBodyAsString());
        }

        if (response != null && response.getStatusCode() == HttpStatus.CREATED) {
            accessTokenFromLiberbank = response.getHeaders().get("token").get(0);
        }

        HttpHeaders headersRespose = new HttpHeaders();
        headersRespose.add("token", accessTokenFromLiberbank);

        response = new ResponseEntity<>(headersRespose, HttpStatus.CREATED);

        log.info("Access-Token from OAuth2 Padawans Liberbank: {}", accessTokenFromLiberbank);
        return response;
    }

    private HttpHeaders getBankapiHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-type", "application/json");
        headers.add("accept", "application/json");

        return headers;
    }
}
