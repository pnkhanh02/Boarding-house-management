package com.example.boardinghousemanagementbackend.service;

import com.example.boardinghousemanagementbackend.modal.dto.HopDongCreateRequest;
import com.example.boardinghousemanagementbackend.modal.dto.HopDongUpdateRequest;
import com.example.boardinghousemanagementbackend.modal.dto.TaiKhoanCreateRequest;
import com.example.boardinghousemanagementbackend.modal.dto.TaiKhoanUpdateRequest;
import com.example.boardinghousemanagementbackend.modal.entity.HopDong;
import com.example.boardinghousemanagementbackend.modal.entity.TaiKhoan;

import java.util.List;

public interface ITaiKhoanService {
    List<TaiKhoan> getAll();

    TaiKhoan getById(long id);

    void delete(long id);

    TaiKhoan create(TaiKhoanCreateRequest request);

    TaiKhoan update(TaiKhoanUpdateRequest request);
}
