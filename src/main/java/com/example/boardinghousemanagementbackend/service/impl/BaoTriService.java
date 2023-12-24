package com.example.boardinghousemanagementbackend.service.impl;

import com.example.boardinghousemanagementbackend.modal.dto.BaoTriCreateRequest;
import com.example.boardinghousemanagementbackend.modal.dto.BaoTriUpdateRequest;
import com.example.boardinghousemanagementbackend.modal.entity.BaoTri;
import com.example.boardinghousemanagementbackend.repository.BaoTriRepository;
import com.example.boardinghousemanagementbackend.service.IBaoTriService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BaoTriService implements IBaoTriService {
    @Autowired
    private BaoTriRepository baoTriRepository;

    @Override
    public List<BaoTri> getAll() {
        return baoTriRepository.findAll();
    }

    @Override
    public BaoTri getById(long id) {
        Optional<BaoTri> optionalBaoTri = baoTriRepository.findById(id);
        if(optionalBaoTri.isPresent()){
            return optionalBaoTri.get();
        }
        return null;
    }

    @Override
    public void delete(long id) {
        baoTriRepository.deleteById(id);
    }

    @Override
    public BaoTri create(BaoTriCreateRequest request) {
        BaoTri baoTri = new BaoTri();
        BeanUtils.copyProperties(request, baoTri);
        return baoTriRepository.save(baoTri);
    }

    @Override
    public BaoTri update(BaoTriUpdateRequest request) {
        BaoTri baoTri = getById(request.getId());
        if(baoTri != null){
            BeanUtils.copyProperties(request, baoTri);
            return baoTriRepository.save(baoTri);
        }
        return null;
    }
}
