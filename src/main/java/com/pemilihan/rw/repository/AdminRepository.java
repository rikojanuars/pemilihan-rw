package com.pemilihan.rw.repository;

import com.pemilihan.rw.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Optional<Admin> findBySecurityCode(String securityCode);
}