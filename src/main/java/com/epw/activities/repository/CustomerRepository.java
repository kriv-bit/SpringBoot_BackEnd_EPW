package com.epw.activities.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epw.activities.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {}

