package com.example.boardinghousemanagementbackend.modal.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN, LANDLORD, CUSTOMER;

    @Override
    public String getAuthority() {
        return name(); // "ADMIN"
    }
}
