package com.example.boardinghousemanagementbackend.modal.dto;

import lombok.Data;

@Data
public class YeuCauUpdateRequest {
    private long id;
    private String title;
    private String phone;
    private String description;

    private long roomId;
}
