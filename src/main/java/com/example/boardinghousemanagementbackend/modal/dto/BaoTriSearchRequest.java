package com.example.boardinghousemanagementbackend.modal.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class BaoTriSearchRequest extends SearchBase{

    private LocalDate maintenanceDate;
}
