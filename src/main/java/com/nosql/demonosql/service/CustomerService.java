package com.nosql.demonosql.service;

import com.nosql.demonosql.dto.CustomerDto;
import com.nosql.demonosql.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> getAllCustomers();
    Customer getCustomerById(String id);
}
