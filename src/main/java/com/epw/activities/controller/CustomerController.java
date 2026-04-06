package com.epw.activities.controller;
import org.springframework.web.bind.annotation.*;

import com.epw.activities.dto.CreateCustomerDto;
import com.epw.activities.entity.Customer;
import com.epw.activities.service.CustomerService;

import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/customers")
@CrossOrigin(origins = "http://localhost:5173") // ¡Vital para evitar error de CORS!
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAll() {
        return customerService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer create(@RequestBody CreateCustomerDto dto) {
        return customerService.save(dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        customerService.deleteById(id);
    }
}