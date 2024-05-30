package com.nosql.demonosql.controller;

import com.nosql.demonosql.dto.CustomerDto;
import com.nosql.demonosql.entity.Customer;
import com.nosql.demonosql.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/demo/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public ResponseEntity<List<CustomerDto>> getAllProviders() {
        List<CustomerDto> customers = customerService.getAllCustomers();

        return ResponseEntity.ok().body(customers);
    }
}
