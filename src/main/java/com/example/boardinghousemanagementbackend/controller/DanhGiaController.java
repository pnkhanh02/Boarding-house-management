package com.example.boardinghousemanagementbackend.controller;

import com.example.boardinghousemanagementbackend.modal.dto.DanhGiaCreateRequest;
import com.example.boardinghousemanagementbackend.modal.dto.DanhGiaUpdateRequest;
import com.example.boardinghousemanagementbackend.modal.entity.DanhGia;
import com.example.boardinghousemanagementbackend.service.IDanhGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/danhgia")
@CrossOrigin("*")
public class DanhGiaController {
    @Autowired
    private IDanhGiaService danhGiaService;

    @GetMapping("/getAll")
    public List<DanhGia> getAll(){
        return danhGiaService.getAll();
    }

    @GetMapping("/{id}")
    public DanhGia getById(@PathVariable long id){
        return danhGiaService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        danhGiaService.delete(id);
    }

    @PostMapping("/create")
    public DanhGia create(@RequestBody DanhGiaCreateRequest request){
        return danhGiaService.create(request);
    }

    @PutMapping("/update")
    public DanhGia update(@RequestBody DanhGiaUpdateRequest request){
        return danhGiaService.update(request);
    }
}
