package com.example.boardinghousemanagementbackend.controller;

import com.example.boardinghousemanagementbackend.modal.dto.BaoTriCreateRequest;
import com.example.boardinghousemanagementbackend.modal.dto.BaoTriUpdateRequest;
import com.example.boardinghousemanagementbackend.modal.dto.HopDongCreateRequest;
import com.example.boardinghousemanagementbackend.modal.dto.HopDongUpdateRequest;
import com.example.boardinghousemanagementbackend.modal.entity.BaoTri;
import com.example.boardinghousemanagementbackend.modal.entity.HopDong;
import com.example.boardinghousemanagementbackend.service.IBaoTriService;
import com.example.boardinghousemanagementbackend.service.impl.BaoTriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/baotri")
public class BaoTriController {
    @Autowired
    private IBaoTriService baoTriService;

    @GetMapping("/getAll")
    public List<BaoTri> getAll(){
        return baoTriService.getAll();
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
    public BaoTri create(@RequestBody BaoTriCreateRequest request){
        return baoTriService.create(request);
    }

    @PutMapping("/update")
    public BaoTri update(@RequestBody BaoTriUpdateRequest request){
        return baoTriService.update(request);
    }
}
