package com.dheeraj.user_service.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequestDto {

    @Email(message = "email should be valid")
    private String email;
    @NotBlank(message = "passwords should not be blank")
    private String password;

}
