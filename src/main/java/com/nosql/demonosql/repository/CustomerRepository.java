package com.nosql.demonosql.repository;

import com.nosql.demonosql.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> { }
