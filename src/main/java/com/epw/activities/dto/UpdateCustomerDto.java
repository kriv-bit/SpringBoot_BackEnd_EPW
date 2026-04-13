package com.epw.activities.dto;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class UpdateCustomerDto {
    
    private String fullName;

    @Email(message = "Email no válido")
    private String email;

    private String phone;
}