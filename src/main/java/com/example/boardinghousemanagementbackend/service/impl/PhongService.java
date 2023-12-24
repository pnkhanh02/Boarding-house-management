package com.example.boardinghousemanagementbackend.service.impl;

import com.example.boardinghousemanagementbackend.modal.dto.PhongCreateRequest;
import com.example.boardinghousemanagementbackend.modal.dto.PhongUpdateRequest;
import com.example.boardinghousemanagementbackend.modal.entity.HopDong;
import com.example.boardinghousemanagementbackend.modal.entity.Phong;
import com.example.boardinghousemanagementbackend.repository.PhongRepository;
import com.example.boardinghousemanagementbackend.service.IPhongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhongService implements IPhongService {
    @Autowired
    private PhongRepository phongRepository;

    @Override
    public List<Phong> getAll() {
        return phongRepository.findAll();
    }

    @Override
    public Phong getById(long id) {
        Optional<Phong> optionalPhong = phongRepository.findById(id);
        if(optionalPhong.isPresent()){
            return optionalPhong.get();
        }
        return null;
    }

    @Override
    public void delete(long id) {
        phongRepository.deleteById(id);
    }

    @Override
    public Phong create(PhongCreateRequest request) {
        Phong phong = new Phong();
        BeanUtils.copyProperties(request, phong);
        return phongRepository.save(phong);
    }

    @Override
    public Phong update(PhongUpdateRequest request) {
        Phong phong = getById(request.getId());
        if(phong != null){
            BeanUtils.copyProperties(request, phong);
            return phongRepository.save(phong);
        }
        return null;
    }
}
