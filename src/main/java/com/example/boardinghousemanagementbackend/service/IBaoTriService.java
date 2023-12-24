package com.example.boardinghousemanagementbackend.service;

import com.example.boardinghousemanagementbackend.modal.dto.BaoTriCreateRequest;
import com.example.boardinghousemanagementbackend.modal.dto.BaoTriUpdateRequest;
import com.example.boardinghousemanagementbackend.modal.dto.HopDongCreateRequest;
import com.example.boardinghousemanagementbackend.modal.dto.HopDongUpdateRequest;
import com.example.boardinghousemanagementbackend.modal.entity.BaoTri;
import com.example.boardinghousemanagementbackend.modal.entity.HopDong;
import com.example.boardinghousemanagementbackend.modal.entity.YeuCau;

import java.util.List;

public interface IBaoTriService {
    List<BaoTri> getAll();

    BaoTri getById(long id);

    void delete(long id);

    BaoTri create(BaoTriCreateRequest request);

    BaoTri update(BaoTriUpdateRequest request);
}
