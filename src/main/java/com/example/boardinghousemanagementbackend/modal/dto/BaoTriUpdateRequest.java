package com.example.boardinghousemanagementbackend.modal.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BaoTriUpdateRequest {
    private long id;
    private LocalDate maintenanceDate;
    private Double price;
    private String description;

    private long roomId;
}
