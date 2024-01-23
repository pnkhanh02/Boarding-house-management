package com.example.boardinghousemanagementbackend.modal.dto;

import lombok.Data;

@Data
public class BinhLuanCreateRequest {

    private String content;

    private long roomId;
    private long accountId;
}
