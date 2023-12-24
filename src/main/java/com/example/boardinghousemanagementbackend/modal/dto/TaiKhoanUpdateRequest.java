package com.example.boardinghousemanagementbackend.modal.dto;

import com.example.boardinghousemanagementbackend.modal.entity.AccountStatus;
import com.example.boardinghousemanagementbackend.modal.entity.Role;
import lombok.Data;

@Data
public class TaiKhoanUpdateRequest {
    private Long id;
    private String name;
    private String username;
    private String password;
    private String phoneNumber;
    private Role role;
    private AccountStatus status;
}
