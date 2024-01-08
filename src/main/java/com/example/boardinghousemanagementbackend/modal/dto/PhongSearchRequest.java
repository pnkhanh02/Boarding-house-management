package com.example.boardinghousemanagementbackend.modal.dto;

import lombok.Data;

@Data
public class PhongSearchRequest extends SearchBase{
    private String title;
    private String address;
    private Double area;
    private Double price;
}
