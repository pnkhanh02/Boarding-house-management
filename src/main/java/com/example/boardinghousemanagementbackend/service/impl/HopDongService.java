package com.example.boardinghousemanagementbackend.service.impl;

import com.example.boardinghousemanagementbackend.modal.dto.HopDongCreateRequest;
import com.example.boardinghousemanagementbackend.modal.dto.HopDongSearchRequest;
import com.example.boardinghousemanagementbackend.modal.dto.HopDongUpdateRequest;
import com.example.boardinghousemanagementbackend.modal.entity.HopDong;
import com.example.boardinghousemanagementbackend.modal.entity.Phong;
import com.example.boardinghousemanagementbackend.repository.HopDongRepository;
import com.example.boardinghousemanagementbackend.repository.PhongRepository;
import com.example.boardinghousemanagementbackend.repository.specification.HopDongSpecification;
import com.example.boardinghousemanagementbackend.repository.specification.PhongSpecification;
import com.example.boardinghousemanagementbackend.service.IHopDongService;
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
public class HopDongService implements IHopDongService {
    @Autowired
    private HopDongRepository hopDongRepository;

    @Autowired
    private PhongRepository phongRepository;

    @Override
    public List<HopDong> getAll() {
        return hopDongRepository.findAll();
    }

    @Override
    public Page<HopDong> search(HopDongSearchRequest request) {
        PageRequest pageRequest = Utils.buildPageRequest(request);
        Specification<HopDong> specification = HopDongSpecification.buildCondition(request);
        return hopDongRepository.findAll(specification, pageRequest);
    }

    @Override
    public int getNumberOfHopDong() {
        return hopDongRepository.findAll().size();
    }

    @Override
    public HopDong getById(Long id) {
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
        hopDong.setName(request.getName());
        hopDong.setStartDate(request.getStartDate());
        hopDong.setEndDate(request.getEndDate());
        hopDong.setNumOfPeople(request.getNumOfPeople());
        hopDong.setRoom(phongRepository.findById(request.getRoomId()));
        hopDongRepository.save(hopDong);
        return hopDong;
    }

    @Override
    public HopDong update(HopDongUpdateRequest request) {
        HopDong hopDong = hopDongRepository.findById(request.getId());
        hopDong.setName(request.getName());
        hopDong.setStartDate(request.getStartDate());
        hopDong.setEndDate(request.getEndDate());
        hopDong.setNumOfPeople(request.getNumOfPeople());
        hopDong.setRoom(phongRepository.findById(request.getRoomId()));
        hopDongRepository.save(hopDong);
        return hopDong;
    }
}
