package com.nosql.demonosql.controller;

import com.nosql.demonosql.dto.CustomerDto;
import com.nosql.demonosql.dto.ErrorResponse;
import com.nosql.demonosql.entity.Customer;
import com.nosql.demonosql.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demo/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        List<CustomerDto> customers = customerService.getAllCustomers();

        return ResponseEntity.ok().body(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCustomerById(@PathVariable("id") String id) {
        CustomerDto customer = customerService.getCustomerById(id);
        if (customer == null) {
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.NOT_FOUND.value(), "Not Found", "please provide a valid id"), HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok().body(customer);
    }

    @PostMapping("/")
    public ResponseEntity<CustomerDto> addCustomer(@Valid @RequestBody CustomerDto customerDto) {
        return new ResponseEntity<CustomerDto>(customerService.addCustomer(customerDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable("id") String id, @Valid @RequestBody CustomerDto customerDto) {
        return new ResponseEntity<CustomerDto>(customerService.updateCustomer(id, customerDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable("id") String id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<Object>("The customer was successfully deleted", HttpStatus.OK);
    }
}
