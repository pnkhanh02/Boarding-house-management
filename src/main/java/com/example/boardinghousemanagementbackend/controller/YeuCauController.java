package com.example.boardinghousemanagementbackend.controller;

import com.example.boardinghousemanagementbackend.modal.dto.*;
import com.example.boardinghousemanagementbackend.modal.entity.HopDong;
import com.example.boardinghousemanagementbackend.modal.entity.YeuCau;
import com.example.boardinghousemanagementbackend.service.IYeuCauService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/yeucau")
@CrossOrigin("*")
public class YeuCauController {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    private IYeuCauService yeuCauService;

    @GetMapping("/getAll")
    public List<YeuCau> getAll() {
        return modelMapper.map(yeuCauService.getAll(), new TypeToken<List<YeuCauDTO>>(){

        }.getType());
    }

    @PostMapping("/search")
    public List<YeuCauDTO> search(@RequestBody YeuCauSearchRequest request) {
        List<YeuCau> yeuCaus = yeuCauService.search(request).getContent();
        return modelMapper.map(yeuCaus, new TypeToken<List<YeuCauDTO>>() {
        }.getType());
    }

    @GetMapping("/{id}")
    public YeuCau getById(@PathVariable long id) {
        return yeuCauService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        yeuCauService.delete(id);
    }

    @PostMapping("/create")
    public YeuCauDTO create(@RequestBody YeuCauCreateRequest request) {
        return modelMapper.map(yeuCauService.create(request),YeuCauDTO.class);
    }

    @PutMapping("/update")
    public YeuCauDTO update(@RequestBody YeuCauUpdateRequest request) {
        return modelMapper.map(yeuCauService.update(request),YeuCauDTO.class);
    }

    @GetMapping(value = "size")
    public int getNumberOfYeuCau() {
        return yeuCauService.getNumberOfYeuCau();
    }
}
