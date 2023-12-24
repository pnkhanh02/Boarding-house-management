package com.example.boardinghousemanagementbackend.repository;

import com.example.boardinghousemanagementbackend.modal.entity.BinhLuan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BinhLuanRepository extends JpaRepository<BinhLuan, Long> {
}
