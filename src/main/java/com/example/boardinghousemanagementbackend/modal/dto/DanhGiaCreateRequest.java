package com.example.boardinghousemanagementbackend.modal.dto;

import com.example.boardinghousemanagementbackend.modal.entity.Rating;
import lombok.Data;

@Data
public class DanhGiaCreateRequest {
    private int rating;

    private long roomId;
    private long accountId;
}
