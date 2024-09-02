package com.esg.service;

import com.esg.config.EnvironmentConfig;
import com.esg.exception.ApiException;
import com.esg.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestClient {

    private RestTemplate restTemplate;
    private String endpoint;

    @Autowired
    private EnvironmentConfig envConfig;

    public RestClient(String endpoint, RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.endpoint = endpoint;
    }

    public void sendCustomerData(List<Customer> customers) {
         try {
             for (Customer customer : customers) {
                 HttpHeaders headers = new HttpHeaders();
                 headers.setContentType(MediaType.APPLICATION_JSON);
                 HttpEntity<Customer> request = new HttpEntity<>(customer, headers);
                 restTemplate.postForObject(endpoint, request, String.class);
             }
         }
         catch (Exception exception){
             throw new ApiException("Something went wrong. Please try again", HttpStatus.INTERNAL_SERVER_ERROR.value());
         }
    }
}
