package com.example.boardinghousemanagementbackend.controller;

import com.example.boardinghousemanagementbackend.modal.dto.YeuCauCreateRequest;
import com.example.boardinghousemanagementbackend.modal.dto.YeuCauUpdateRequest;
import com.example.boardinghousemanagementbackend.modal.entity.YeuCau;
import com.example.boardinghousemanagementbackend.service.IYeuCauService;
import com.example.boardinghousemanagementbackend.service.impl.YeuCauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/yeucau")
public class YeuCauController {
    @Autowired
    private IYeuCauService yeuCauService;

    @GetMapping("/getAll")
    public List<YeuCau> getAll(){
        return yeuCauService.getAll();
    }

    @GetMapping("/{id}")
    public YeuCau getById(@PathVariable long id){
        return yeuCauService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        yeuCauService.delete(id);
    }

    @PostMapping("/create")
    public YeuCau create(@RequestBody YeuCauCreateRequest request){
        return yeuCauService.create(request);
    }

    @PutMapping("/update")
    public YeuCau update(@RequestBody YeuCauUpdateRequest request){
        return yeuCauService.update(request);
    }
}
