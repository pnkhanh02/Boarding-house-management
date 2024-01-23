package com.example.boardinghousemanagementbackend.controller;

import com.example.boardinghousemanagementbackend.modal.dto.*;
import com.example.boardinghousemanagementbackend.modal.entity.BaoTri;
import com.example.boardinghousemanagementbackend.modal.entity.HopDong;
import com.example.boardinghousemanagementbackend.modal.entity.YeuCau;
import com.example.boardinghousemanagementbackend.service.IBaoTriService;
import com.example.boardinghousemanagementbackend.service.impl.BaoTriService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/baotri")
@CrossOrigin("*")
public class BaoTriController {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    private IBaoTriService baoTriService;

    @GetMapping("/getAll")
    public List<BaoTri> getAll(){
        return modelMapper.map(baoTriService.getAll(), new TypeToken<List<BaoTriDTO>>(){

        }.getType());
    }

    @PostMapping("/search")
    public List<BaoTriDTO> search(@RequestBody BaoTriSearchRequest request){
        List<BaoTri> baoTris = baoTriService.search(request).getContent();
        return modelMapper.map(baoTris, new TypeToken<List<BaoTriDTO>>() {
        }.getType());
    }

    @GetMapping(value = "size")
    public int getNumberOfBaoTri(){
        return baoTriService.getNumberOfBaoTri();
    }

    @GetMapping("/{id}")
    public BaoTri getById(@PathVariable long id){
        return baoTriService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        baoTriService.delete(id);
    }

    @PostMapping("/create")
    public BaoTriDTO create(@RequestBody BaoTriCreateRequest request){
        return modelMapper.map(baoTriService.create(request),BaoTriDTO.class);
    }

    @PutMapping("/update")
    public BaoTriDTO update(@RequestBody BaoTriUpdateRequest request){
        return modelMapper.map(baoTriService.update(request),BaoTriDTO.class);
    }


}
