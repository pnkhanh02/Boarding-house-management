package com.example.boardinghousemanagementbackend.modal.dto;

import lombok.Data;

@Data
public class BinhLuanUpdateRequest {
    private Long id;
    private String content;

    private long roomId;
    private long accountId;
}
