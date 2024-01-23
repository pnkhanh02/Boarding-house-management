package com.example.boardinghousemanagementbackend.modal.dto;

import com.example.boardinghousemanagementbackend.modal.entity.RoomStatus;
import com.example.boardinghousemanagementbackend.modal.entity.TaiKhoan;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@Data
@NoArgsConstructor
public class PhongDTO {
    private Long id;
    private String title;
    private String address;

    private Double area;

    private Double price;

    @Enumerated(EnumType.STRING)
    private RoomStatus status;

    private String imageUrl;
    List<BinhLuanDTO> binhLuans;
    List<DanhGiaDTO> danhGias;

    @Data
    @NoArgsConstructor
    static class BinhLuanDTO {
        private Long id;
        private String content;
        private TaiKhoan account;
    }

    @Data
    @NoArgsConstructor
    static class DanhGiaDTO {
        private Long id;
        private int rating;
        private TaiKhoan account;
    }
}
