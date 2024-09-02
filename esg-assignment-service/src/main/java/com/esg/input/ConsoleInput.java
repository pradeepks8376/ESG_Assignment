package com.esg.input;

import com.esg.constant.Constants;
import com.esg.exception.ApiException;
import com.esg.model.Customer;
import com.esg.service.RestClient;
import com.esg.util.CsvReader;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Properties;

public class ConsoleInput {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try (InputStream inputStream = ConsoleInput.class.getClassLoader().getResourceAsStream("application.properties"))
        {
            properties.load(inputStream);
        }catch (IOException exception){
            System.out.println("Error loading file "+exception.getMessage());
        }

        try {
            ClassLoader classLoader = ConsoleInput.class.getClassLoader();
            URL resource = classLoader.getResource("customers.csv");
            if(resource == null) {
                throw new ApiException("Customer CSV File not found", HttpStatus.NOT_FOUND.value());
            }
            CsvReader csvReader = new CsvReader();
            List<Customer> customers = csvReader.readCsvFile(resource.getFile());
            if(customers.isEmpty()) {
                throw new ApiException("Customers Data is empty, can't process further", HttpStatus.NO_CONTENT.value());
            }
            RestClient restClient = new RestClient(properties.getProperty(Constants.ENDPOINT), new RestTemplate());
            restClient.sendCustomerData(customers);
        }
        catch (ApiException exception){
            throw new ApiException("Customer data is null hence unable to process request: ", HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        catch (Exception exception){
            throw new ApiException("Something went wrong. Please try again.", HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }
}
