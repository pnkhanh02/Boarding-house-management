package com.example.boardinghousemanagementbackend.controller;

import com.example.boardinghousemanagementbackend.modal.dto.BinhLuanCreateRequest;
import com.example.boardinghousemanagementbackend.modal.dto.BinhLuanUpdateRequest;
import com.example.boardinghousemanagementbackend.modal.entity.BinhLuan;
import com.example.boardinghousemanagementbackend.service.IBinhLuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/binhluan")
@CrossOrigin("*")
public class BinhLuanController {
    @Autowired
    private IBinhLuanService binhLuanService;

    @GetMapping("/getAll")
    public List<BinhLuan> getAll(){
        return binhLuanService.getAll();
    }

    @GetMapping("/{id}")
    public BinhLuan getById(@PathVariable long id){
        return binhLuanService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        binhLuanService.delete(id);
    }

    @PostMapping("/create")
    public BinhLuan create(@RequestBody BinhLuanCreateRequest request){
        return binhLuanService.create(request);
    }

    @PutMapping("/update")
    public BinhLuan update(@RequestBody BinhLuanUpdateRequest request){
        return binhLuanService.update(request);
    }
}
