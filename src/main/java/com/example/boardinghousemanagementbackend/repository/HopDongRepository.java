package com.example.boardinghousemanagementbackend.repository;

import com.example.boardinghousemanagementbackend.modal.entity.HopDong;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HopDongRepository extends JpaRepository<HopDong, Long>, JpaSpecificationExecutor<HopDong> {
    HopDong findByRoomId(long roomId);
    HopDong findById(long id);
}
