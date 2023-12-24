package com.example.boardinghousemanagementbackend.service.impl;

import com.example.boardinghousemanagementbackend.modal.dto.HopDongCreateRequest;
import com.example.boardinghousemanagementbackend.modal.dto.HopDongUpdateRequest;
import com.example.boardinghousemanagementbackend.modal.entity.HopDong;
import com.example.boardinghousemanagementbackend.repository.HopDongRepository;
import com.example.boardinghousemanagementbackend.service.IHopDongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HopDongService implements IHopDongService {
    @Autowired
    private HopDongRepository hopDongRepository;

    @Override
    public List<HopDong> getAll() {
        return hopDongRepository.findAll();
    }

    @Override
    public HopDong getById(long id) {
        Optional<HopDong> optionalHopDong = hopDongRepository.findById(id);
        if(optionalHopDong.isPresent()){
            return optionalHopDong.get();
        }
        return null;
    }

    @Override
    public void delete(long id) {
        hopDongRepository.deleteById(id);
    }

    @Override
    public HopDong create(HopDongCreateRequest request) {
        HopDong hopDong = new HopDong();
        BeanUtils.copyProperties(request, hopDong);
        return hopDongRepository.save(hopDong);
    }

    @Override
    public HopDong update(HopDongUpdateRequest request) {
        HopDong hopDong = getById(request.getId());
        if(hopDong != null){
            BeanUtils.copyProperties(request, hopDong);
            return hopDongRepository.save(hopDong);
        }
        return null;
    }
}
