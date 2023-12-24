package com.example.boardinghousemanagementbackend.modal.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class HopDongCreateRequest {
    private String name;
    private LocalDate deadline;
    private Integer numOfPeople;
}
