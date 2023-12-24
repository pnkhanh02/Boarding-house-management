package com.example.boardinghousemanagementbackend.service;

import com.example.boardinghousemanagementbackend.modal.dto.PhongCreateRequest;
import com.example.boardinghousemanagementbackend.modal.dto.PhongUpdateRequest;
import com.example.boardinghousemanagementbackend.modal.dto.TaiKhoanCreateRequest;
import com.example.boardinghousemanagementbackend.modal.dto.TaiKhoanUpdateRequest;
import com.example.boardinghousemanagementbackend.modal.entity.Phong;
import com.example.boardinghousemanagementbackend.modal.entity.TaiKhoan;

import java.util.List;

public interface IPhongService {
    List<Phong> getAll();

    Phong getById(long id);

    void delete(long id);

    Phong create(PhongCreateRequest request);

    Phong update(PhongUpdateRequest request);
}
