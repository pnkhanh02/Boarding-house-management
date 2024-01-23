package com.example.boardinghousemanagementbackend.modal.dto;

import com.example.boardinghousemanagementbackend.modal.entity.Phong;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class HopDongDTO {

    private Long id;

    private String name;

    private LocalDate startDate;

    private LocalDate endDate;

    private Integer numOfPeople;

    private String roomTitle;

    private Long roomId;
}
