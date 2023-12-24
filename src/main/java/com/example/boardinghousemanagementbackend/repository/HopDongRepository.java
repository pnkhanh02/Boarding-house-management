package com.example.boardinghousemanagementbackend.repository;

import com.example.boardinghousemanagementbackend.modal.entity.HopDong;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HopDongRepository extends JpaRepository<HopDong, Long> {

}
