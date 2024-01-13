package com.example.boardinghousemanagementbackend.service.impl;

import com.example.boardinghousemanagementbackend.modal.dto.PhongCreateRequest;
import com.example.boardinghousemanagementbackend.modal.dto.PhongSearchRequest;
import com.example.boardinghousemanagementbackend.modal.dto.PhongUpdateRequest;
import com.example.boardinghousemanagementbackend.modal.entity.HopDong;
import com.example.boardinghousemanagementbackend.modal.entity.Phong;
import com.example.boardinghousemanagementbackend.repository.HopDongRepository;
import com.example.boardinghousemanagementbackend.repository.PhongRepository;
import com.example.boardinghousemanagementbackend.repository.specification.PhongSpecification;
import com.example.boardinghousemanagementbackend.service.IPhongService;
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
public class PhongService implements IPhongService {
    @Autowired
    HopDongRepository hopDongRepository;

    @Autowired
    private PhongRepository phongRepository;

    @Override
    public List<Phong> getAll() {
        return phongRepository.findAll();
    }

    @Override
    public Page<Phong> search(PhongSearchRequest request) {
        PageRequest pageRequest = Utils.buildPageRequest(request);
        Specification<Phong> specification = PhongSpecification.buildCondition(request);
        return phongRepository.findAll(specification, pageRequest);
    }

    @Override
    public Phong getById(long id) {
        Optional<Phong> optionalPhong = phongRepository.findById((Long) id);
        if (optionalPhong.isPresent()) {
            return optionalPhong.get();
        }
        return null;
    }

    @Override
    public void delete(long id) {
        HopDong hopDong = hopDongRepository.findByRoomId(id);
        if (hopDong != null) {
            hopDongRepository.delete(hopDong);
        }
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
        if (phong != null) {
            BeanUtils.copyProperties(request, phong);
            return phongRepository.save(phong);
        }
        return null;
    }
}
