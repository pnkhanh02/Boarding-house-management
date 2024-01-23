package com.example.boardinghousemanagementbackend.service;

import com.example.boardinghousemanagementbackend.modal.dto.*;
import com.example.boardinghousemanagementbackend.modal.entity.BaoTri;
import com.example.boardinghousemanagementbackend.modal.entity.HopDong;
import com.example.boardinghousemanagementbackend.modal.entity.YeuCau;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

public interface IBaoTriService {
    List<BaoTri> getAll();

    Page<BaoTri> search(BaoTriSearchRequest request);

    int getNumberOfBaoTri();

    BaoTri getById(Long id);

    void delete(long id);

    BaoTri create(BaoTriCreateRequest request);

    BaoTri update(BaoTriUpdateRequest request);

}
