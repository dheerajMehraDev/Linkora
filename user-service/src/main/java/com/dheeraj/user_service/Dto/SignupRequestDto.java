package com.dheeraj.user_service.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignupRequestDto {

    @Email(message = "email is not valid")
    private String email;

    @NotBlank(message = "password can not be blank")
    private String password;

    @NotBlank(message = "name can not be blank")
    private String name;
}
