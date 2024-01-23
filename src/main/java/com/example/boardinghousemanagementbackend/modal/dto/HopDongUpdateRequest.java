package com.example.boardinghousemanagementbackend.modal.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class HopDongUpdateRequest {
    private long id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer numOfPeople;

    private long roomId;
}
