package com.example.boardinghousemanagementbackend.modal.dto;

import com.example.boardinghousemanagementbackend.modal.entity.Rating;
import lombok.Data;

@Data
public class DanhGiaUpdateRequest {
    private Long id;
    private Rating rating;
}
