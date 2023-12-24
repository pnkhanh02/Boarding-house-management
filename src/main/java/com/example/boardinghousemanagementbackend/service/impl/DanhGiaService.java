package com.example.boardinghousemanagementbackend.service.impl;

import com.example.boardinghousemanagementbackend.modal.dto.DanhGiaCreateRequest;
import com.example.boardinghousemanagementbackend.modal.dto.DanhGiaUpdateRequest;
import com.example.boardinghousemanagementbackend.modal.entity.BinhLuan;
import com.example.boardinghousemanagementbackend.modal.entity.DanhGia;
import com.example.boardinghousemanagementbackend.repository.DanhGiaRepository;
import com.example.boardinghousemanagementbackend.service.IDanhGiaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DanhGiaService implements IDanhGiaService {
    @Autowired
    private DanhGiaRepository danhGiaRepository;

    @Override
    public List<DanhGia> getAll() {
        return danhGiaRepository.findAll();
    }

    @Override
    public DanhGia getById(long id) {
        Optional<DanhGia> optionalDanhGia = danhGiaRepository.findById(id);
        if(optionalDanhGia.isPresent()){
            return optionalDanhGia.get();
        }
        return null;
    }

    @Override
    public void delete(long id) {
        danhGiaRepository.deleteById(id);
    }

    @Override
    public DanhGia create(DanhGiaCreateRequest request) {
        DanhGia danhGia = new DanhGia();
        BeanUtils.copyProperties(request, danhGia);
        return danhGiaRepository.save(danhGia);
    }

    @Override
    public DanhGia update(DanhGiaUpdateRequest request) {
        DanhGia danhGia = getById(request.getId());
        if(danhGia != null){
            BeanUtils.copyProperties(request, danhGia);
            return danhGiaRepository.save(danhGia);
        }
        return null;
    }
}
