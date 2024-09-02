package com.esg.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import com.esg.model.Customer;
import org.junit.jupiter.api.Test;
public class CsvReaderTest {
    @Test
    public void testReadCsvFile() {
        CsvReader csvReader = new CsvReader();
        List<Customer> customers = csvReader.readCsvFile("src/test/resources/customers.csv");

        assertNotNull(customers);
        assertEquals(5, customers.size());

        Customer firstCustomer = customers.get(0);
        assertEquals("10001", firstCustomer.getCustomerRef());
        assertEquals("John", firstCustomer.getCustomerName());
        assertEquals("122", firstCustomer.getAddressLine1());
        assertEquals("Chapel Street", firstCustomer.getAddressLine2());
        assertEquals("Sale", firstCustomer.getTown());
        assertEquals("Cheshire", firstCustomer.getCounty());
        assertEquals("United Kingdom", firstCustomer.getCountry());
        assertEquals("M215SG", firstCustomer.getPostcode());
    }
}
