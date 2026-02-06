package com.dheeraj.user_service.Service.Interface;


import com.dheeraj.user_service.Dto.LoginRequestDto;
import com.dheeraj.user_service.Dto.SignupRequestDto;
import com.dheeraj.user_service.Dto.UserDto;
import jakarta.validation.Valid;

public interface AuthService {
    UserDto signUp(SignupRequestDto dto);

    String login( LoginRequestDto dto);
}
