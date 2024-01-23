package com.example.boardinghousemanagementbackend.modal.dto;

import com.example.boardinghousemanagementbackend.modal.entity.TaiKhoan;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DanhGiaDTO {
    private Long id;
    private int rating;
    private TaiKhoan account;
}
