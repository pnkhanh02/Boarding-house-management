package com.example.boardinghousemanagementbackend.service;

import com.example.boardinghousemanagementbackend.modal.dto.HopDongCreateRequest;
import com.example.boardinghousemanagementbackend.modal.dto.HopDongUpdateRequest;
import com.example.boardinghousemanagementbackend.modal.entity.HopDong;

import java.util.List;

public interface IHopDongService {
    List<HopDong> getAll();

    HopDong getById(long id);

    void delete(long id);

    HopDong create(HopDongCreateRequest request);

    HopDong update(HopDongUpdateRequest request);
}
