package com.example.boardinghousemanagementbackend.service;

import com.example.boardinghousemanagementbackend.modal.dto.YeuCauCreateRequest;
import com.example.boardinghousemanagementbackend.modal.dto.YeuCauUpdateRequest;
import com.example.boardinghousemanagementbackend.modal.entity.HopDong;
import com.example.boardinghousemanagementbackend.modal.entity.YeuCau;

import java.util.List;

public interface IYeuCauService {
    List<YeuCau> getAll();

    YeuCau getById(long id);

    void delete(long id);

    YeuCau create(YeuCauCreateRequest request);

    YeuCau update(YeuCauUpdateRequest request);
}
