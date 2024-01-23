package com.example.boardinghousemanagementbackend.controller;

import com.example.boardinghousemanagementbackend.exception.CustomException;
import com.example.boardinghousemanagementbackend.exception.ErrorResponseEnum;
import com.example.boardinghousemanagementbackend.modal.dto.LoginDto;
import com.example.boardinghousemanagementbackend.modal.dto.LoginRequest;
import com.example.boardinghousemanagementbackend.modal.entity.AccountStatus;
import com.example.boardinghousemanagementbackend.modal.entity.TaiKhoan;
import com.example.boardinghousemanagementbackend.repository.TaiKhoanRepository;
import com.example.boardinghousemanagementbackend.utils.JWTTokenUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin("*")
public class AuthController {
    @Autowired
    TaiKhoanRepository taiKhoanRepository;

    @Autowired
    JWTTokenUtils jwtTokenUtils;

    @PostMapping("/login-v1") //Thực hiện theo cách này thì cần mở public API này ra
    public LoginDto login(@RequestParam String username, @RequestParam String password){
        Optional<TaiKhoan> accountOptional = taiKhoanRepository.findByUsername(username);
        if(accountOptional.isEmpty()){
            throw new CustomException(ErrorResponseEnum.USERNAME_NOT_FOUND);
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        TaiKhoan taiKhoan = accountOptional.get();


        //So sánh password
        boolean checkPassword = passwordEncoder.matches(password, taiKhoan.getPassword());
        if(!checkPassword){
            throw new CustomException(ErrorResponseEnum.PASSWORD_FAILS);
        }

        LoginDto loginDto = new LoginDto();
        BeanUtils.copyProperties(taiKhoan, loginDto);
        return loginDto;
    }

    @PostMapping("/login-jwt") //Thực hiện theo cách này thì cần mở public API này ra
    public LoginDto loginJwt(@RequestBody LoginRequest request){
        Optional<TaiKhoan> accountOptional = taiKhoanRepository.findByUsername(request.getUsername());
        if(accountOptional.isEmpty()){
            throw new CustomException(ErrorResponseEnum.USERNAME_NOT_FOUND);
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        TaiKhoan taiKhoan = accountOptional.get();


        //So sánh password
        boolean checkPassword = passwordEncoder.matches(request.getPassword(), taiKhoan.getPassword());
        if(!checkPassword){
            throw new CustomException(ErrorResponseEnum.PASSWORD_FAILS);
        }
        //Check account status
        if(taiKhoan.getStatus() != AccountStatus.ACTIVE){
            throw new CustomException(ErrorResponseEnum.ACC_NOT_ACTIVE);
        }
        LoginDto loginDto = new LoginDto();
        BeanUtils.copyProperties(taiKhoan, loginDto);

        //Tạo ra token để return
        String token = jwtTokenUtils.createAccessToken(loginDto);
        loginDto.setToken(token);
        return loginDto;
    }

}
