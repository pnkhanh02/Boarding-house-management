package com.example.boardinghousemanagementbackend.modal.dto;

import lombok.Data;

@Data
public class YeuCauUpdateRequest {
    private Long id;
    private String name;
    private String phone;
    private String description;
}
