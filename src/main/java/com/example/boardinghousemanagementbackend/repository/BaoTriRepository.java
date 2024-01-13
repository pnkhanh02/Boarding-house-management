package com.example.boardinghousemanagementbackend.repository;

import com.example.boardinghousemanagementbackend.modal.entity.BaoTri;
import com.example.boardinghousemanagementbackend.modal.entity.HopDong;
import com.example.boardinghousemanagementbackend.modal.entity.YeuCau;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BaoTriRepository extends JpaRepository<BaoTri, Long>, JpaSpecificationExecutor<BaoTri> {
    BaoTri findByRoomId(long roomId);
    BaoTri findById(long id);
}
