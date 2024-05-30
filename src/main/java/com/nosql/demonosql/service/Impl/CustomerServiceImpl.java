package com.nosql.demonosql.service.Impl;

import com.nosql.demonosql.dto.CustomerDto;
import com.nosql.demonosql.entity.Customer;
import com.nosql.demonosql.repository.CustomerRepository;
import com.nosql.demonosql.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<CustomerDto> getAllCustomers() {
//        customerRepository.save(customerRepository.insert(new Customer("Oma''r", "ee", "33")));
        return customerRepository.findAll().stream().map(this::mapToDTO).toList();
    }

    @Override
    public Customer getCustomerById(String id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        return optionalCustomer.orElse(null);
    }

    public CustomerDto mapToDTO(Customer customer) {
        return new CustomerDto(customer.getId(), customer.getName(), customer.getEmail());
    }
}
