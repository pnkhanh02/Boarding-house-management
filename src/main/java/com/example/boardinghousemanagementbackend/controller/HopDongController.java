package com.example.boardinghousemanagementbackend.controller;

import com.example.boardinghousemanagementbackend.modal.dto.HopDongCreateRequest;
import com.example.boardinghousemanagementbackend.modal.dto.HopDongDTO;
import com.example.boardinghousemanagementbackend.modal.dto.HopDongSearchRequest;
import com.example.boardinghousemanagementbackend.modal.dto.HopDongUpdateRequest;
import com.example.boardinghousemanagementbackend.modal.entity.HopDong;
import com.example.boardinghousemanagementbackend.service.IHopDongService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hopdong")
@CrossOrigin("*")
public class HopDongController {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    private IHopDongService hopDongService;

    @GetMapping("/getAll")
    public List<HopDong> getAll() {
        return modelMapper.map(hopDongService.getAll(), new TypeToken<List<HopDongDTO>>() {
        }.getType());
    }

    @PostMapping("/search")
    public List<HopDongDTO> search(@RequestBody HopDongSearchRequest request) {
        List<HopDong> hopDongs = hopDongService.search(request).getContent();
        return modelMapper.map(hopDongs, new TypeToken<List<HopDongDTO>>() {
        }.getType());
    }

    @GetMapping(value = "size")
    public int getNumberOfHopDong() {
        return hopDongService.getNumberOfHopDong();
    }

    @GetMapping("/{id}")
    public HopDong getById(@PathVariable long id) {
        return hopDongService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        hopDongService.delete(id);
    }

    @PostMapping("/create")
    public HopDongDTO create(@RequestBody HopDongCreateRequest request) {
        return modelMapper.map(hopDongService.create(request),HopDongDTO.class);
    }

    @PutMapping("/update")
    public HopDongDTO update(@RequestBody HopDongUpdateRequest request) {
        return modelMapper.map(hopDongService.update(request),HopDongDTO.class);
    }
}
