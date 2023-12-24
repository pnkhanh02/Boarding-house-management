package com.example.boardinghousemanagementbackend.controller;

import com.example.boardinghousemanagementbackend.modal.dto.HopDongCreateRequest;
import com.example.boardinghousemanagementbackend.modal.dto.HopDongUpdateRequest;
import com.example.boardinghousemanagementbackend.modal.entity.HopDong;
import com.example.boardinghousemanagementbackend.service.IHopDongService;
import com.example.boardinghousemanagementbackend.service.impl.HopDongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hopdong")
public class HopDongController {
    @Autowired
    private IHopDongService hopDongService;

    @GetMapping("/getAll")
    public List<HopDong> getAll(){
        return hopDongService.getAll();
    }

    @GetMapping("/{id}")
    public HopDong getById(@PathVariable long id){
        return hopDongService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        hopDongService.delete(id);
    }

    @PostMapping("/create")
    public HopDong create(@RequestBody HopDongCreateRequest request){
        return hopDongService.create(request);
    }

    @PutMapping("/update")
    public HopDong update(@RequestBody HopDongUpdateRequest request){
        return hopDongService.update(request);
    }
}
