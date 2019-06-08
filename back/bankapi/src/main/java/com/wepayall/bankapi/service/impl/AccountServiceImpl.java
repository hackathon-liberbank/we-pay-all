package com.wepayall.bankapi.service.impl;
// package com.padawans.hackaton.bankapi.service.impl;
//
// import java.net.URI;
// import java.util.Date;
// import java.util.UUID;
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpHeaders;
// import org.springframework.http.HttpMethod;
// import org.springframework.http.RequestEntity;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Service;
// import org.springframework.web.client.HttpClientErrorException;
// import org.springframework.web.client.RestTemplate;
// import org.springframework.web.util.UriComponentsBuilder;
//
// import com.padawans.hackaton.bankapi.generated.model.AccountsResponse;
// import com.padawans.hackaton.bankapi.generated.model.BalancesResponse;
// import com.padawans.hackaton.bankapi.generated.model.TransactionResponse;
// import com.padawans.hackaton.bankapi.oauth2.TokenData;
// import com.padawans.hackaton.bankapi.oauth2.TokenOAuth2;
// import com.padawans.hackaton.bankapi.properties.LiberbankOauth2Properties;
// import com.padawans.hackaton.bankapi.service.AccountService;
//
// import lombok.extern.slf4j.Slf4j;
//
// @Service
// @Slf4j
// public class AccountServiceImpl implements AccountService {
//
// @Autowired
// LiberbankOauth2Properties properties;
//
// public ResponseEntity<AccountsResponse> accountsGet(String token, UUID xRequestId) {
// HttpHeaders headers = getLiberbankHeaderForAccounts(token, xRequestId);
//
// String url = "https://api-glbk.liberbank.es/tpps/sb/psd2/v1.0/accounts";
//
// UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
//
// URI uri = builder.build().toUri();
//
// RequestEntity<AccountsResponse> request = new RequestEntity<AccountsResponse>(headers, HttpMethod.GET, uri);
//
// RestTemplate restTemplate = new RestTemplate();
//
// ResponseEntity<AccountsResponse> response = null;
//
// try {
// response = restTemplate.exchange(uri, HttpMethod.GET, request, AccountsResponse.class);
// } catch (final HttpClientErrorException e) {
// log.info(e.getStatusCode().toString());
// log.info(e.getResponseBodyAsString());
// }
//
// return response;
// }
//
// public ResponseEntity<BalancesResponse> accountsAccountIdBalancesGet(String token, String accountId,
// UUID xRequestId) {
// HttpHeaders headers = getLiberbankHeaderForAccountBalances(token, xRequestId);
//
// String url = "https://api-glbk.liberbank.es/tpps/sb/psd2/v1.0/accounts/";
//
// UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).path(accountId).path("/balances");
//
// URI uri = builder.build().toUri();
//
// RequestEntity<BalancesResponse> request = new RequestEntity<>(headers, HttpMethod.GET, uri);
//
// RestTemplate restTemplate = new RestTemplate();
//
// ResponseEntity<BalancesResponse> response = null;
//
// try {
// response = restTemplate.exchange(uri, HttpMethod.GET, request, BalancesResponse.class);
// } catch (final HttpClientErrorException e) {
// log.info(e.getStatusCode().toString());
// log.info(e.getResponseBodyAsString());
// }
//
// return response;
// }
//
// public ResponseEntity<TransactionResponse> accountsAccountIdTransactionsGet(String token, String accountId,
// UUID xRequestId, Date dateFrom, Date dateTo) {
// HttpHeaders headers = getLiberbankHeaderForAccountTransactions(token, xRequestId);
//
// String url = "https://api-glbk.liberbank.es/tpps/sb/psd2/v1.0/accounts/";
//
// // DateFormat dateFormat = new SimpleDateFormat("dd-/mm/aaaa");
//
// // No funciona con parámetros opcionales
// // MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
// // map.add("dateFrom", dateFormat.format(dateFrom));
// // map.add("dateTo", dateFormat.format(dateTo));
// //
// // UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).path(accountId).path("/transactions")
// // .queryParams(map);
//
// UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).path(accountId).path("/transactions");
//
// URI uri = builder.build().toUri();
//
// RequestEntity<TransactionResponse> request = new RequestEntity<>(headers, HttpMethod.GET, uri);
//
// RestTemplate restTemplate = new RestTemplate();
//
// ResponseEntity<TransactionResponse> response = null;
//
// try {
// response = restTemplate.exchange(uri, HttpMethod.GET, request, TransactionResponse.class);
// } catch (final HttpClientErrorException e) {
// log.info(e.getStatusCode().toString());
// log.info(e.getResponseBodyAsString());
// }
//
// return response;
// }
//
// private HttpHeaders getLiberbankHeaderForAccounts(String token, UUID xRequestId) {
// TokenData tokenData = new TokenData(properties);
//
// TokenOAuth2 tokenGenerator = new TokenOAuth2(tokenData);
//
// HttpHeaders headers = new HttpHeaders();
// headers.add("accept", "application/json");
// headers.add("x-request-id", xRequestId.toString());
// headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + tokenGenerator.getAccessTokenFromLiberbankForAccount());
//
// return headers;
// }
//
// private HttpHeaders getLiberbankHeaderForAccountBalances(String token, UUID xRequestId) {
// TokenData tokenData = new TokenData(properties);
//
// TokenOAuth2 tokenGenerator = new TokenOAuth2(tokenData);
//
// HttpHeaders headers = new HttpHeaders();
// headers.add("accept", "application/json");
// headers.add("x-request-id", xRequestId.toString());
// headers.add(HttpHeaders.AUTHORIZATION,
// "Bearer " + tokenGenerator.getAccessTokenFromLiberbankForAccountBalances());
//
// return headers;
// }
//
// private HttpHeaders getLiberbankHeaderForAccountTransactions(String token, UUID xRequestId) {
// TokenData tokenData = new TokenData(properties);
//
// TokenOAuth2 tokenGenerator = new TokenOAuth2(tokenData);
//
// HttpHeaders headers = new HttpHeaders();
// headers.add("accept", "application/json");
// headers.add("x-request-id", xRequestId.toString());
// headers.add(HttpHeaders.AUTHORIZATION,
// "Bearer " + tokenGenerator.getAccessTokenFromLiberbankForAccountTransactions());
//
// return headers;
// }
//
// }
