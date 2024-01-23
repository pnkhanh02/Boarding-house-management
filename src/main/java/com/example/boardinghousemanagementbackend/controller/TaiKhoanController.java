package com.example.boardinghousemanagementbackend.controller;

import com.example.boardinghousemanagementbackend.modal.dto.*;
import com.example.boardinghousemanagementbackend.modal.entity.HopDong;
import com.example.boardinghousemanagementbackend.modal.entity.Phong;
import com.example.boardinghousemanagementbackend.modal.entity.TaiKhoan;
import com.example.boardinghousemanagementbackend.service.IHopDongService;
import com.example.boardinghousemanagementbackend.service.ITaiKhoanService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/taikhoan")
@CrossOrigin("*")
@Validated
public class TaiKhoanController {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    private ITaiKhoanService taiKhoanService;

    @GetMapping("/getAll")
    public List<TaiKhoanDTO> getAll(){
        return modelMapper.map(taiKhoanService.getAll(), new TypeToken<List<TaiKhoanDTO>>() {
        }.getType());
    }

    @PostMapping("/search")
    public List<TaiKhoanDTO> search(@RequestBody TaiKhoanSearchRequest request){
        List<TaiKhoan> taiKhoans = taiKhoanService.search(request).getContent();
        return modelMapper.map(taiKhoans, new TypeToken<List<TaiKhoanDTO>>() {
        }.getType());
    }

    @GetMapping(value = "size")
    public int getNumberOfTaiKhoan(){
        return taiKhoanService.getNumberOfTaiKhoan();
    }

    @GetMapping("/{id}")
    public TaiKhoanDTO getById(@PathVariable long id){
        return modelMapper.map(taiKhoanService.getById(id),TaiKhoanDTO.class);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        taiKhoanService.delete(id);
    }

    @PostMapping("/create")
    public TaiKhoanDTO create(@RequestBody @Valid TaiKhoanCreateRequest request){
        return modelMapper.map(taiKhoanService.create(request),TaiKhoanDTO.class);
    }

    @PutMapping("/update")
    public TaiKhoanDTO update(@RequestBody TaiKhoanUpdateRequest request){
        return modelMapper.map(taiKhoanService.update(request),TaiKhoanDTO.class);
    }
}
