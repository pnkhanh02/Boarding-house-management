package com.example.boardinghousemanagementbackend.modal.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "BaoTri")
@Data
public class BaoTri {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "maintenanceDate", nullable = false)
    private LocalDate maintenanceDate;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "description")
    private String description;

    //Khóa ngoại tới Phong
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Phong room;

}
