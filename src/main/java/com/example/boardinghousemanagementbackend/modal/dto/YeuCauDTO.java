package com.example.boardinghousemanagementbackend.modal.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class YeuCauDTO {
    private Long id;
    private String title;
    private String phone;
    private String description;
    private String roomTitle;
    private Long roomId;
}
