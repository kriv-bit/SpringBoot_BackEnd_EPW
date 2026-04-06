package com.epw.activities.service;

import java.util.List;

import com.epw.activities.dto.CreateCustomerDto;
import com.epw.activities.entity.Customer;

public interface CustomerService {
    List<Customer> findAll();
    Customer findById(Long id);
    Customer save(CreateCustomerDto dto);
    void deleteById(Long id);
}