package com.esg.util.restclient;

import static org.mockito.Mockito.*;

import java.util.List;

import com.esg.model.Customer;
import com.esg.service.RestClient;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

public class RestClientTest {
    @Test
    public void testSendCustomerData() {
        RestTemplate restTemplate = mock(RestTemplate.class);
        String endpoint = "http://localhost:8081/api/customers/save";
        RestClient restClient = new RestClient(endpoint, restTemplate);

        List<Customer> customers = List.of(new Customer("10001", "John", "122", "Chapel Street", "Sale", "Cheshire", "United Kingdom", "M215SG"));
        restClient.sendCustomerData(customers);

        verify(restTemplate, times(1)).postForObject(anyString(), any(), eq(String.class));
    }
}
