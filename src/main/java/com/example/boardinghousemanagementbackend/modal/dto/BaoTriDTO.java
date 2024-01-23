package com.example.boardinghousemanagementbackend.modal.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class BaoTriDTO {
    private Long id;
    private LocalDate maintenanceDate;
    private Double price;
    private String description;
    private String roomTitle;
    private Long roomId;
}
