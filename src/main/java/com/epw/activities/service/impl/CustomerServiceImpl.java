package com.epw.activities.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epw.activities.dto.CreateCustomerDto;
import com.epw.activities.entity.Customer;
import com.epw.activities.repository.CustomerRepository;
import com.epw.activities.service.CustomerService;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    // Inyección por constructor (la mejor práctica)
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Customer findById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + id));
    }

    @Override
    @Transactional
    public Customer save(CreateCustomerDto dto) {
        Customer customer = new Customer();
        customer.setFullName(dto.getFullName());
        customer.setEmail(dto.getEmail());
        customer.setPhone(dto.getPhone());
        
        return customerRepository.save(customer);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new RuntimeException("No se puede borrar: ID no existe");
        }
        customerRepository.deleteById(id);
    }

}