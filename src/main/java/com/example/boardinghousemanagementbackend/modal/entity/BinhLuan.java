package com.example.boardinghousemanagementbackend.modal.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "BinhLuan",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"account_id", "room_id"})
        }
)
@Data
public class BinhLuan {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content", nullable = false, length = 500)
    private String content;

    //Khóa ngoại tới Phong
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Phong room;

    //Khóa ngoại tới TaiKhoan
    @ManyToOne
    @JoinColumn(name = "account_id")
    private TaiKhoan account;

}
