package com.example.boardinghousemanagementbackend.controller;

import com.example.boardinghousemanagementbackend.modal.dto.PhongCreateRequest;
import com.example.boardinghousemanagementbackend.modal.dto.PhongUpdateRequest;
import com.example.boardinghousemanagementbackend.modal.entity.Phong;
import com.example.boardinghousemanagementbackend.service.IPhongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/phong")
public class PhongController {
    @Autowired
    private IPhongService phongService;

    @GetMapping("/getAll")
    public List<Phong> getAll(){
        return phongService.getAll();
    }

    @GetMapping("/{id}")
    public Phong getById(@PathVariable long id){
        return phongService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        phongService.delete(id);
    }

    @PostMapping("/create")
    public Phong create(@RequestBody PhongCreateRequest request){
        return phongService.create(request);
    }

    @PutMapping("/update")
    public Phong update(@RequestBody PhongUpdateRequest request){
        return phongService.update(request);
    }
}
