package com.example.boardinghousemanagementbackend.service;

import com.example.boardinghousemanagementbackend.modal.dto.BaoTriCreateRequest;
import com.example.boardinghousemanagementbackend.modal.dto.BaoTriUpdateRequest;
import com.example.boardinghousemanagementbackend.modal.dto.BinhLuanCreateRequest;
import com.example.boardinghousemanagementbackend.modal.dto.BinhLuanUpdateRequest;
import com.example.boardinghousemanagementbackend.modal.entity.BaoTri;
import com.example.boardinghousemanagementbackend.modal.entity.BinhLuan;

import java.util.List;

public interface IBinhLuanService {
    List<BinhLuan> getAll();

    BinhLuan getById(long id);

    void delete(long id);

    BinhLuan create(BinhLuanCreateRequest request);

    BinhLuan update(BinhLuanUpdateRequest request);
}
