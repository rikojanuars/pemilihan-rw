package com.pemilihan.rw.repository;

import com.pemilihan.rw.entity.TokenPemilih;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenPemilihRepository extends JpaRepository<TokenPemilih, Integer> {
    Optional<TokenPemilih> findByTokenAndIdPeriode(String token, int idPeriode);
}