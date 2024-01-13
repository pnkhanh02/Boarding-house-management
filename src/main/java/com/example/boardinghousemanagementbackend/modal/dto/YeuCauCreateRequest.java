package com.example.boardinghousemanagementbackend.modal.dto;

import lombok.Data;

@Data
public class YeuCauCreateRequest {
    private String title;
    private String phone;
    private String description;

    private long roomId;
}
