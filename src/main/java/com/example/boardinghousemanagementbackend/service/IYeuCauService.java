package com.example.boardinghousemanagementbackend.service;

import com.example.boardinghousemanagementbackend.modal.dto.TaiKhoanSearchRequest;
import com.example.boardinghousemanagementbackend.modal.dto.YeuCauCreateRequest;
import com.example.boardinghousemanagementbackend.modal.dto.YeuCauSearchRequest;
import com.example.boardinghousemanagementbackend.modal.dto.YeuCauUpdateRequest;
import com.example.boardinghousemanagementbackend.modal.entity.HopDong;
import com.example.boardinghousemanagementbackend.modal.entity.TaiKhoan;
import com.example.boardinghousemanagementbackend.modal.entity.YeuCau;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IYeuCauService {
    List<YeuCau> getAll();

    Page<YeuCau> search(YeuCauSearchRequest request);

    int getNumberOfYeuCau();

    YeuCau getById(Long id);

    void delete(long id);

    YeuCau create(YeuCauCreateRequest request);

    YeuCau update(YeuCauUpdateRequest request);
}
