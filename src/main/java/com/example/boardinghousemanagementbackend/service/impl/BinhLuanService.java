package com.example.boardinghousemanagementbackend.service.impl;

import com.example.boardinghousemanagementbackend.modal.dto.BinhLuanCreateRequest;
import com.example.boardinghousemanagementbackend.modal.dto.BinhLuanUpdateRequest;
import com.example.boardinghousemanagementbackend.modal.entity.BaoTri;
import com.example.boardinghousemanagementbackend.modal.entity.BinhLuan;
import com.example.boardinghousemanagementbackend.repository.BinhLuanRepository;
import com.example.boardinghousemanagementbackend.repository.PhongRepository;
import com.example.boardinghousemanagementbackend.repository.TaiKhoanRepository;
import com.example.boardinghousemanagementbackend.service.IBinhLuanService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BinhLuanService implements IBinhLuanService {
    @Autowired
    private BinhLuanRepository binhLuanRepository;

    @Autowired
    private PhongRepository phongRepository;

    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Override
    public List<BinhLuan> getAll() {
        return binhLuanRepository.findAll();
    }

    @Override
    public BinhLuan getById(long id) {
        Optional<BinhLuan> optionalBinhLuan = binhLuanRepository.findById(id);
        if(optionalBinhLuan.isPresent()){
            return optionalBinhLuan.get();
        }
        return null;
    }

    @Override
    public void delete(long id) {
        binhLuanRepository.deleteById(id);
    }

    @Override
    public BinhLuan create(BinhLuanCreateRequest request) {
        BinhLuan binhLuan = new BinhLuan();
        binhLuan.setAccount(taiKhoanRepository.findById(request.getAccountId()));
        binhLuan.setRoom(phongRepository.findById(request.getRoomId()));
        binhLuan.setContent(request.getContent());
        binhLuanRepository.save(binhLuan);
        return binhLuan;
    }

    @Override
    public BinhLuan update(BinhLuanUpdateRequest request) {
        BinhLuan binhLuan = getById(request.getId());
        if(binhLuan != null){
            BeanUtils.copyProperties(request, binhLuan);
            return binhLuanRepository.save(binhLuan);
        }
        return null;
    }
}
