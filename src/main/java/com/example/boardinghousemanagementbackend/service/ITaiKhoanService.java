package com.example.boardinghousemanagementbackend.service;

import com.example.boardinghousemanagementbackend.modal.dto.*;
import com.example.boardinghousemanagementbackend.modal.entity.HopDong;
import com.example.boardinghousemanagementbackend.modal.entity.Phong;
import com.example.boardinghousemanagementbackend.modal.entity.TaiKhoan;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ITaiKhoanService {
    List<TaiKhoan> getAll();

    Page<TaiKhoan> search(TaiKhoanSearchRequest request);

    int getNumberOfTaiKhoan();

    TaiKhoan getById(Long id);

    void delete(long id);

    TaiKhoan create(TaiKhoanCreateRequest request);

    TaiKhoan update(TaiKhoanUpdateRequest request);
}
