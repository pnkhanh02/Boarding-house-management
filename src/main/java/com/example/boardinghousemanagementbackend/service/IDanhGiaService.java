package com.example.boardinghousemanagementbackend.service;

import com.example.boardinghousemanagementbackend.modal.dto.BinhLuanCreateRequest;
import com.example.boardinghousemanagementbackend.modal.dto.BinhLuanUpdateRequest;
import com.example.boardinghousemanagementbackend.modal.dto.DanhGiaCreateRequest;
import com.example.boardinghousemanagementbackend.modal.dto.DanhGiaUpdateRequest;
import com.example.boardinghousemanagementbackend.modal.entity.BinhLuan;
import com.example.boardinghousemanagementbackend.modal.entity.DanhGia;

import java.util.List;

public interface IDanhGiaService {
    List<DanhGia> getAll();

    DanhGia getById(long id);

    void delete(long id);

    DanhGia create(DanhGiaCreateRequest request);

    DanhGia update(DanhGiaUpdateRequest request);
}
