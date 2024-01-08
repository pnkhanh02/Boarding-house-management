package com.example.boardinghousemanagementbackend.service;

import com.example.boardinghousemanagementbackend.modal.dto.*;
import com.example.boardinghousemanagementbackend.modal.entity.Phong;
import com.example.boardinghousemanagementbackend.modal.entity.TaiKhoan;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IPhongService {
    List<Phong> getAll();

    Page<Phong> search(PhongSearchRequest request);

    Phong getById(long id);

    void delete(long id);

    Phong create(PhongCreateRequest request);

    Phong update(PhongUpdateRequest request);
}
