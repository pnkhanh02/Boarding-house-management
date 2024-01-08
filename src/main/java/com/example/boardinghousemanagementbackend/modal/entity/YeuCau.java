package com.example.boardinghousemanagementbackend.modal.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "YeuCau")
@Data
public class YeuCau {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "phone", nullable = false, length = 20)
    private String phone;

    @Column(name = "description", nullable = false, length = 500)
    private String description;

    //Khóa ngoại tới Phong
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Phong room;

}
