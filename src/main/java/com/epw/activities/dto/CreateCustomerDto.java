package com.epw.activities.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateCustomerDto {
    
    @NotBlank(message = "El nombre es obligatorio")
    private String fullName;

    @Email(message = "Email no válido")
    @NotBlank(message = "El email es obligatorio")
    private String email;

    private String phone;
}