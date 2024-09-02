package com.esg.controller;

import com.esg.config.EnvironmentConfig;
import com.esg.constant.Constants;
import com.esg.entity.CustomerEntity;
import com.esg.exception.ApiException;
import com.esg.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(Constants.BASE_URL)
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EnvironmentConfig envConfig;

    @PostMapping(Constants.SAVE_URI)
    public ResponseEntity saveCustomer(@RequestBody CustomerEntity customer) throws ApiException {
        try {
            if(Optional.of(customer).isEmpty()) {
                throw new ApiException("Input parameter is missing or empty ", HttpStatus.BAD_REQUEST.value());
            }
            return ResponseEntity.of(Optional.of(customerRepository.save(customer)));
        }catch (Exception exception){
            throw new ApiException("Error Occurred While Saving Data", HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

    @GetMapping(Constants.GET_URI)
    public ResponseEntity<CustomerEntity> getCustomer(@PathVariable String customerRef) {
       try {
           Optional<CustomerEntity> customer = customerRepository.findById(customerRef);
           if (customer.isEmpty()) {
               throw new ApiException(String.format("CustomerRef: %s, not found", customerRef), HttpStatus.NOT_FOUND.value());
           }
           return ResponseEntity.of(customer);
       }catch (ApiException apiException){
           throw new ApiException(String.format("CustomerRef: %s, not found", customerRef), HttpStatus.NOT_FOUND.value());
       } catch (Exception exception){
           throw new ApiException("Error Occurred While retrieving customerRef", HttpStatus.INTERNAL_SERVER_ERROR.value());
       }
    }
}
