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

    @Column(name = "startDate", nullable = false)
    private LocalDate startDate;

    @Column(name = "endDate", nullable = false)
    private LocalDate endDate;

    @Column(name = "numOfPeople")
    private Integer numOfPeople;

    //Khóa ngoại tới Phong
    @OneToOne
    @JoinColumn(name = "room_id")
    private Phong room;

    //Thêm khóa ngoại accountId1 (bên A), accountId2(bên B), startDate, endDate
    //Tìm kiếm ngày hiện tại trong khoảng (startDate, endDate)
    //Thêm 1 class thu, chi theo tháng ( có các trường id, createDate, HopDongId, BaoTriId)
    //Kiểm tra ngày của maintainDate có thuộc tháng này không
    //1 api GET dữ liệu theo từng hợp đồng có thu, chi
    //1 api tính toán cho chủ trọ trong tháng(input đầu vào có accountId1, month)
    // admin tính chiết khấu % của chủ trọ đó, tính tổng
    //trong bảng account có trường chiết khấu % (chỉ có giá trị với role chủ trọ)

}
