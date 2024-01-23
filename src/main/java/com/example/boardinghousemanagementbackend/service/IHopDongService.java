package com.example.boardinghousemanagementbackend.service;

import com.example.boardinghousemanagementbackend.modal.dto.HopDongCreateRequest;
import com.example.boardinghousemanagementbackend.modal.dto.HopDongSearchRequest;
import com.example.boardinghousemanagementbackend.modal.dto.HopDongUpdateRequest;
import com.example.boardinghousemanagementbackend.modal.dto.TaiKhoanSearchRequest;
import com.example.boardinghousemanagementbackend.modal.entity.HopDong;
import com.example.boardinghousemanagementbackend.modal.entity.TaiKhoan;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IHopDongService {
    List<HopDong> getAll();

    Page<HopDong> search(HopDongSearchRequest request);

    int getNumberOfHopDong();

    HopDong getById(Long id);

    void delete(long id);

    HopDong create(HopDongCreateRequest request);

    HopDong update(HopDongUpdateRequest request);
}
