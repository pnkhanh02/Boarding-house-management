package com.example.boardinghousemanagementbackend.modal.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(
        name = "DanhGia",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"account_id", "room_id"})
        }
)
@Data
public class DanhGia {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rating")
    private int rating;

    //Khóa ngoại tới Phong
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Phong room;

    //Khóa ngoại tới TaiKhoan
    @ManyToOne
    @JoinColumn(name = "account_id")
    private TaiKhoan account;


}
