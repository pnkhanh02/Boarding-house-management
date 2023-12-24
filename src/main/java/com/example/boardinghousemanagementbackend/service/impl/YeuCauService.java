package com.example.boardinghousemanagementbackend.service.impl;


import com.example.boardinghousemanagementbackend.modal.dto.YeuCauCreateRequest;
import com.example.boardinghousemanagementbackend.modal.dto.YeuCauUpdateRequest;
import com.example.boardinghousemanagementbackend.modal.entity.YeuCau;
import com.example.boardinghousemanagementbackend.repository.YeuCauRepository;
import com.example.boardinghousemanagementbackend.service.IYeuCauService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class YeuCauService implements IYeuCauService {
    @Autowired
    private YeuCauRepository yeuCauRepository;

    @Override
    public List<YeuCau> getAll() {
        return yeuCauRepository.findAll();
    }

    @Override
    public YeuCau getById(long id) {
        Optional<YeuCau> optionalYeuCau = yeuCauRepository.findById(id);
        if(optionalYeuCau.isPresent()){
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
        BeanUtils.copyProperties(request, yeuCau);
        return yeuCauRepository.save(yeuCau);
    }

    @Override
    public YeuCau update(YeuCauUpdateRequest request) {
        YeuCau yeuCau = getById(request.getId());
        if(yeuCau != null){
            BeanUtils.copyProperties(request, yeuCau);
            return yeuCauRepository.save(yeuCau);
        }
        return null;
    }
}
