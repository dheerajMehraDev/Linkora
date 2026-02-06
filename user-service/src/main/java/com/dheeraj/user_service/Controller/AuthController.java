package com.dheeraj.user_service.Controller;

import com.dheeraj.user_service.Dto.LoginRequestDto;
import com.dheeraj.user_service.Dto.SignupRequestDto;
import com.dheeraj.user_service.Dto.UserDto;
import com.dheeraj.user_service.Service.Interface.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signUp(@RequestBody @Valid SignupRequestDto dto){
        UserDto userDto = authService.signUp(dto);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginRequestDto dto){
        String token = authService.login(dto);
        return new ResponseEntity<>(token , HttpStatus.OK);
    }

}
