package com.example.boardinghousemanagementbackend.modal.dto;

import com.example.boardinghousemanagementbackend.modal.entity.TaiKhoan;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BinhLuanDTO {
    private Long id;
    private String content;
    private TaiKhoan account;
}
