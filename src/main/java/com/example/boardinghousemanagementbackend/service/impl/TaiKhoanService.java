package com.example.boardinghousemanagementbackend.service.impl;

import com.example.boardinghousemanagementbackend.modal.dto.TaiKhoanCreateRequest;
import com.example.boardinghousemanagementbackend.modal.dto.TaiKhoanSearchRequest;
import com.example.boardinghousemanagementbackend.modal.dto.TaiKhoanUpdateRequest;
import com.example.boardinghousemanagementbackend.modal.entity.HopDong;
import com.example.boardinghousemanagementbackend.modal.entity.Phong;
import com.example.boardinghousemanagementbackend.modal.entity.TaiKhoan;
import com.example.boardinghousemanagementbackend.repository.TaiKhoanRepository;
import com.example.boardinghousemanagementbackend.repository.specification.PhongSpecification;
import com.example.boardinghousemanagementbackend.repository.specification.TaiKhoanSpecification;
import com.example.boardinghousemanagementbackend.service.ITaiKhoanService;
import com.example.boardinghousemanagementbackend.utils.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
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
    public Page<TaiKhoan> search(TaiKhoanSearchRequest request) {
        PageRequest pageRequest = Utils.buildPageRequest(request);
        Specification<TaiKhoan> specification = TaiKhoanSpecification.buildCondition(request);
        return taiKhoanRepository.findAll(specification, pageRequest);
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
