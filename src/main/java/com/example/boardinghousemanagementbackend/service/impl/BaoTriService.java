package com.example.boardinghousemanagementbackend.service.impl;

import com.example.boardinghousemanagementbackend.modal.dto.BaoTriCreateRequest;
import com.example.boardinghousemanagementbackend.modal.dto.BaoTriSearchRequest;
import com.example.boardinghousemanagementbackend.modal.dto.BaoTriUpdateRequest;
import com.example.boardinghousemanagementbackend.modal.entity.BaoTri;
import com.example.boardinghousemanagementbackend.repository.BaoTriRepository;
import com.example.boardinghousemanagementbackend.repository.PhongRepository;
import com.example.boardinghousemanagementbackend.repository.specification.BaoTriSpecification;
import com.example.boardinghousemanagementbackend.service.IBaoTriService;
import com.example.boardinghousemanagementbackend.utils.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BaoTriService implements IBaoTriService {
    @Autowired
    private BaoTriRepository baoTriRepository;

    @Autowired
    private PhongRepository phongRepository;

    @Override
    public List<BaoTri> getAll() {
        return baoTriRepository.findAll();
    }

    @Override
    public Page<BaoTri> search(BaoTriSearchRequest request) {
        PageRequest pageRequest = Utils.buildPageRequest(request);
        Specification<BaoTri> specification = BaoTriSpecification.buildCondition(request);
        return baoTriRepository.findAll(specification, pageRequest);
    }

    @Override
    public BaoTri getById(Long id) {
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
        baoTri.setMaintenanceDate(request.getMaintenanceDate());
        baoTri.setDescription(request.getDescription());
        baoTri.setPrice(request.getPrice());
        baoTri.setRoom(phongRepository.findById(request.getRoomId()));
        baoTriRepository.save(baoTri);
        return baoTri;
    }

    @Override
    public BaoTri update(BaoTriUpdateRequest request) {
        BaoTri baoTri = baoTriRepository.findById(request.getId());
        baoTri.setMaintenanceDate(request.getMaintenanceDate());
        baoTri.setDescription(request.getDescription());
        baoTri.setPrice(request.getPrice());
        baoTri.setRoom(phongRepository.findById(request.getRoomId()));
        baoTriRepository.save(baoTri);
        return baoTri;
    }
}
