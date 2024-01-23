package com.example.boardinghousemanagementbackend.controller;

import com.example.boardinghousemanagementbackend.modal.dto.*;
import com.example.boardinghousemanagementbackend.modal.entity.BinhLuan;
import com.example.boardinghousemanagementbackend.service.IBinhLuanService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/binhluan")
@CrossOrigin("*")
public class BinhLuanController {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    private IBinhLuanService binhLuanService;

    @GetMapping("/getAll")
    public List<BinhLuanDTO> getAll(){
        return modelMapper.map(binhLuanService.getAll(), new TypeToken<List<BinhLuanDTO>>() {
        }.getType());
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
    public BinhLuanDTO create(@RequestBody BinhLuanCreateRequest request){
        return modelMapper.map(binhLuanService.create(request), BinhLuanDTO.class);
    }

    @PutMapping("/update")
    public BinhLuan update(@RequestBody BinhLuanUpdateRequest request){
        return binhLuanService.update(request);
    }
}
