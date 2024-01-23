package com.example.boardinghousemanagementbackend.controller;

import com.example.boardinghousemanagementbackend.modal.dto.PhongCreateRequest;
import com.example.boardinghousemanagementbackend.modal.dto.PhongDTO;
import com.example.boardinghousemanagementbackend.modal.dto.PhongSearchRequest;
import com.example.boardinghousemanagementbackend.modal.dto.PhongUpdateRequest;
import com.example.boardinghousemanagementbackend.modal.entity.Phong;
import com.example.boardinghousemanagementbackend.service.IPhongService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/phong")
@CrossOrigin("*")
public class PhongController {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    private IPhongService phongService;

    @GetMapping("/getAll")
    public List<PhongDTO> getAll() {

        return modelMapper.map(phongService.getAll(), new TypeToken<List<PhongDTO>>() {
        }.getType());
    }

    @PostMapping("/search")
    public List<PhongDTO> search(@RequestBody PhongSearchRequest request) {
       Page<Phong> phongs = phongService.search(request);
       List<Phong> phongs1 = phongs.getContent();
       List<PhongDTO> phongDTOS = modelMapper.map(phongs1, new TypeToken<List<PhongDTO>>() {
       }.getType());
       return  phongDTOS;
    }

    @GetMapping(value = "size")
    public int getNumberOfPhong() {
        return phongService.getNumberOfPhong();
    }


    @GetMapping("/{id}")
    public PhongDTO getById(@PathVariable long id) {
        return modelMapper.map(phongService.getById(id),PhongDTO.class);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        phongService.delete(id);
    }

    @PostMapping("/create")
    public Phong create(@RequestBody PhongCreateRequest request) {
        return phongService.create(request);
    }

    @PutMapping("/update")
    public PhongDTO update(@RequestBody PhongUpdateRequest request) {
        return modelMapper.map(phongService.update(request),PhongDTO.class);
    }
}
