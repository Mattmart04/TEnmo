package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.AuthenticatedUser;
import com.techelevator.tenmo.model.UserCredentials;
import com.techelevator.util.BasicLogger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

public class AccountService {

    private static final String API_BASE_URL = "http://localhost:8080/";
    private final RestTemplate restTemplate = new RestTemplate();
    public BigDecimal getAccountBalance(AuthenticatedUser credentials) {
        BigDecimal balance = null;
        try{
            ResponseEntity<BigDecimal> response = restTemplate.exchange(API_BASE_URL+"MyBalance", HttpMethod.GET,makeEntity(credentials),BigDecimal.class);
            balance = response.getBody();
        }catch(RestClientResponseException | ResourceAccessException e){
            BasicLogger.log(e.getMessage());
        }
        return balance;
    }

    public Account getMyAccount(AuthenticatedUser user) {
        Account account = null;
        System.out.println(user.getUser());
        try {
            ResponseEntity<Account> response =
                    restTemplate.exchange(API_BASE_URL + "MyAccount", HttpMethod.GET, makeEntity(user), Account.class);
            account = response.getBody();

        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());

        }
        return account;
    }

    private HttpEntity<Void> makeEntity(AuthenticatedUser user){
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(user.getToken());
        return new HttpEntity<>(headers);
    }
}
