package com.example.boardinghousemanagementbackend.service.impl;

import com.example.boardinghousemanagementbackend.modal.dto.TaiKhoanCreateRequest;
import com.example.boardinghousemanagementbackend.modal.dto.TaiKhoanUpdateRequest;
import com.example.boardinghousemanagementbackend.modal.entity.HopDong;
import com.example.boardinghousemanagementbackend.modal.entity.TaiKhoan;
import com.example.boardinghousemanagementbackend.repository.TaiKhoanRepository;
import com.example.boardinghousemanagementbackend.service.ITaiKhoanService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaiKhoanService implements ITaiKhoanService {
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Override
    public List<TaiKhoan> getAll() {
        return taiKhoanRepository.findAll();
    }

    @Override
    public TaiKhoan getById(long id) {
        Optional<TaiKhoan> optionalTaiKhoan = taiKhoanRepository.findById(id);
        if(optionalTaiKhoan.isPresent()){
            return optionalTaiKhoan.get();
        }
        return null;
    }

    @Override
    public void delete(long id) {
        taiKhoanRepository.deleteById(id);
    }

    @Override
    public TaiKhoan create(TaiKhoanCreateRequest request) {
        TaiKhoan taiKhoan = new TaiKhoan();
        BeanUtils.copyProperties(request, taiKhoan);
        return taiKhoanRepository.save(taiKhoan);
    }

    @Override
    public TaiKhoan update(TaiKhoanUpdateRequest request) {
        TaiKhoan taiKhoan = getById(request.getId());
        if(taiKhoan != null){
            BeanUtils.copyProperties(request, taiKhoan);
            return taiKhoanRepository.save(taiKhoan);
        }
        return null;
    }
}
