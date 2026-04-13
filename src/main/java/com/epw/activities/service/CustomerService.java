package com.epw.activities.service;

import java.util.List;

import com.epw.activities.dto.CreateCustomerDto;
import com.epw.activities.dto.UpdateCustomerDto;
import com.epw.activities.entity.Customer;

public interface CustomerService {
    List<Customer> findAll();
    Customer findById(Long id);
    Customer save(CreateCustomerDto dto);
    // Nuevo método:
    Customer update(Long id, UpdateCustomerDto dto); 
    void deleteById(Long id);
}