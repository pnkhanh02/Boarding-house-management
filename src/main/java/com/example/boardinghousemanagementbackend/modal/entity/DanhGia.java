package com.example.boardinghousemanagementbackend.modal.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "DanhGia")
@Data
public class DanhGia {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rating")
    @Enumerated(EnumType.STRING)
    private Rating rating;
}
