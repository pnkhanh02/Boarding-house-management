package com.example.boardinghousemanagementbackend.modal.entity;

//import jakarta.persistence.*;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "HopDong")
@Data
public class HopDong {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "deadline", nullable = false)
    private LocalDate deadline;

    @Column(name = "numOfPeople", nullable = false)
    private Integer numOfPeople;
}
