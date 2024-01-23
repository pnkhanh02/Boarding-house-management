package com.example.boardinghousemanagementbackend.service.impl;


import com.example.boardinghousemanagementbackend.modal.dto.YeuCauCreateRequest;
import com.example.boardinghousemanagementbackend.modal.dto.YeuCauSearchRequest;
import com.example.boardinghousemanagementbackend.modal.dto.YeuCauUpdateRequest;
import com.example.boardinghousemanagementbackend.modal.entity.YeuCau;
import com.example.boardinghousemanagementbackend.repository.PhongRepository;
import com.example.boardinghousemanagementbackend.repository.YeuCauRepository;
import com.example.boardinghousemanagementbackend.repository.specification.YeuCauSpecification;
import com.example.boardinghousemanagementbackend.service.IYeuCauService;
import com.example.boardinghousemanagementbackend.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class YeuCauService implements IYeuCauService {
    @Autowired
    private YeuCauRepository yeuCauRepository;

    @Autowired
    private PhongRepository phongRepository;

    @Override
    public List<YeuCau> getAll() {
        return yeuCauRepository.findAll();
    }

    @Override
    public Page<YeuCau> search(YeuCauSearchRequest request) {
        PageRequest pageRequest = Utils.buildPageRequest(request);
        Specification<YeuCau> specification = YeuCauSpecification.buildCondition(request);
        return yeuCauRepository.findAll(specification, pageRequest);
    }

    @Override
    public int getNumberOfYeuCau() {

        return yeuCauRepository.findAll().size();
    }

    @Override
    public YeuCau getById(Long id) {
        Optional<YeuCau> optionalYeuCau = yeuCauRepository.findById(id);
        if (optionalYeuCau.isPresent()) {
            return optionalYeuCau.get();
        }
        return null;
    }

    @Override
    public void delete(long id) {
        yeuCauRepository.deleteById(id);
    }

    @Override
    public YeuCau create(YeuCauCreateRequest request) {
        YeuCau yeuCau = new YeuCau();
        yeuCau.setTitle(request.getTitle());
        yeuCau.setDescription(request.getDescription());
        yeuCau.setPhone(request.getPhone());
        yeuCau.setRoom(phongRepository.findById(request.getRoomId()));
        yeuCauRepository.save(yeuCau);
        return yeuCau;
    }

    @Override
    public YeuCau update(YeuCauUpdateRequest request) {
        YeuCau yeuCau = yeuCauRepository.findById(request.getId());
        yeuCau.setTitle(request.getTitle());
        yeuCau.setDescription(request.getDescription());
        yeuCau.setPhone(request.getPhone());
        yeuCau.setRoom(phongRepository.findById(request.getRoomId()));
        yeuCauRepository.save(yeuCau);
        return yeuCau;
    }
}
