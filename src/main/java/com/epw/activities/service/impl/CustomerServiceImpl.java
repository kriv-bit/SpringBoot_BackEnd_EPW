package com.epw.activities.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epw.activities.dto.CreateCustomerDto;
import com.epw.activities.dto.UpdateCustomerDto; // Asegúrate de importar tu nuevo DTO
import com.epw.activities.entity.Customer;
import com.epw.activities.repository.CustomerRepository;
import com.epw.activities.service.CustomerService;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    // Inyección por constructor (Excelente práctica)
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
    public Customer update(Long id, UpdateCustomerDto dto) {
        // Buscamos el cliente existente
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se puede actualizar: Cliente no encontrado con ID: " + id));

        // Actualizamos solo los campos que no vienen nulos en el DTO
        if (dto.getFullName() != null) {
            customer.setFullName(dto.getFullName());
        }
        if (dto.getEmail() != null) {
            customer.setEmail(dto.getEmail());
        }
        if (dto.getPhone() != null) {
            customer.setPhone(dto.getPhone());
        }

        // Al estar dentro de una transacción, los cambios se guardan automáticamente,
        // pero llamar a .save() es una buena práctica para mayor claridad.
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