package com.dheeraj.user_service.Service;

import com.dheeraj.user_service.Dto.LoginRequestDto;
import com.dheeraj.user_service.Dto.SignupRequestDto;
import com.dheeraj.user_service.Dto.UserDto;
import com.dheeraj.user_service.Entity.User;
import com.dheeraj.user_service.Exception.BadRequestException;
import com.dheeraj.user_service.Exception.ResourceNotFoundException;
import com.dheeraj.user_service.Repository.UserRepository;
import com.dheeraj.user_service.Security.JwtService;
import com.dheeraj.user_service.Service.Interface.AuthService;
import com.dheeraj.user_service.Util.PasswordUtil;
import io.jsonwebtoken.Jwt;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {


    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final JwtService jwtService;


    @Override
    public UserDto signUp(SignupRequestDto dto) {
      User user = modelMapper.map(dto , User.class);
      user.setPassword(PasswordUtil.hashPassword(dto.getPassword()));
        User savedUser = userRepository.save(user);
       return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public String login(LoginRequestDto dto) {
        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("user not found for email " + dto.getEmail()));

        boolean isPasswordMatch = PasswordUtil.verifyPassword(dto.getPassword(),user.getPassword());

        if(!isPasswordMatch){
            throw new BadRequestException("enter valid password for the user ");
        }
        return jwtService.getSecretToken(user);
    }
}
