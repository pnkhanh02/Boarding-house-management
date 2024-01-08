package com.example.boardinghousemanagementbackend.modal.dto;

import lombok.Data;

@Data
public class YeuCauCreateRequest {
    private String name;
    private String phone;
    private String description;

    private Long phongId;
}
