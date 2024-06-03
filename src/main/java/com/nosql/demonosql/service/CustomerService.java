package com.nosql.demonosql.service;

import com.nosql.demonosql.dto.CustomerDto;
import com.nosql.demonosql.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> getAllCustomers();
    CustomerDto getCustomerById(String id);
    CustomerDto addCustomer(CustomerDto customerDto);
    CustomerDto updateCustomer(String id, CustomerDto customerDto);
    void deleteCustomer(String id);
}
