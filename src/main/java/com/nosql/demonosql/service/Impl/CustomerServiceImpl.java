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
    public CustomerDto getCustomerById(String id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);

        return optionalCustomer.map(this::mapToDTO).orElse(null);
    }

    @Override
    public CustomerDto addCustomer(CustomerDto customerDto) {
        Customer customer = mapToEntity(customerDto);
        customerRepository.insert(customer);
        return customerDto;
    }

    @Override
    public CustomerDto updateCustomer(String id, CustomerDto customerDto) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isEmpty()) return null;

        customer.get().setName(customerDto.getName());
        customer.get().setEmail(customerDto.getEmail());
        return mapToDTO(customerRepository.save(customer.get()));
    }

    @Override
    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }

    public CustomerDto mapToDTO(Customer customer) {
        return new CustomerDto(customer.getId(), customer.getName(), customer.getEmail());
    }

    public Customer mapToEntity(CustomerDto customerDto) {
        return new Customer(customerDto.getId(), customerDto.getName(), customerDto.getEmail());
    }
}
