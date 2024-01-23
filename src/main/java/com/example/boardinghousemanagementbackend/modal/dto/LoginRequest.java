package com.example.boardinghousemanagementbackend.modal.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
