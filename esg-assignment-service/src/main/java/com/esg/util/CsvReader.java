package com.esg.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.esg.model.Customer;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class CsvReader {

    public List<Customer> readCsvFile(String filePath) {
        List<Customer> customers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT
                    .withHeader("CustomerRef", "CustomerName", "AddressLine1", "AddressLine2", "Town", "County", "Country", "Postcode")
                    .withFirstRecordAsHeader()
                    .parse(reader);

            for (CSVRecord record : records) {
                Customer customer = new Customer(
                        record.get("CustomerRef"),
                        record.get("CustomerName"),
                        record.get("AddressLine1"),
                        record.get("AddressLine2"),
                        record.get("Town"),
                        record.get("County"),
                        record.get("Country"),
                        record.get("Postcode")
                );
                customers.add(customer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return customers;
    }
}
