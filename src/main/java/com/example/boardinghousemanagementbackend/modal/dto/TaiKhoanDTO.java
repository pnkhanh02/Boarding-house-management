package com.example.boardinghousemanagementbackend.modal.dto;

import com.example.boardinghousemanagementbackend.modal.entity.AccountStatus;
import com.example.boardinghousemanagementbackend.modal.entity.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@NoArgsConstructor
public class TaiKhoanDTO {
    private Long id;
    private String name;
    private String username;
    private String password;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;

//    List<RoomDTO> rooms;
//
//    static class RoomDTO{
//        List<HD> hd;
//        List<BẢOTRI>
//    }
}
