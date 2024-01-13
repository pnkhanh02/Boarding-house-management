package com.example.boardinghousemanagementbackend.modal.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Phong")
@Data
public class Phong {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "address", nullable = false, length = 500)
    private String address;

    @Column(name = "area", nullable = false)
    private Double area;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private RoomStatus status;

    @Column(name = "imageUrl", length = 500)
    private String imageUrl;
}

