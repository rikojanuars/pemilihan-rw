package com.pemilihan.rw.service;

import com.pemilihan.rw.entity.Admin;
import com.pemilihan.rw.entity.TokenPemilih;
import com.pemilihan.rw.repository.AdminRepository;
import com.pemilihan.rw.repository.TokenPemilihRepository;
import com.pemilihan.rw.utility.AES;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    TokenPemilihRepository tokenPemilihRepository;

    @Override
    public void generateToken(int idPeriode, int qtyToken) {
         for(int i = 0; i < qtyToken; i++){
             String token = checkToken(RandomStringUtils.randomNumeric(5), idPeriode);
             TokenPemilih tokenBaru = new TokenPemilih(token, idPeriode, Boolean.TRUE);
             tokenPemilihRepository.saveAndFlush(tokenBaru);
         }
    }

    @Override
    public String checkToken(String token, int idPeriode) {
        Optional<TokenPemilih> checkToken = tokenPemilihRepository.findByTokenAndIdPeriode(token, idPeriode);
        while (checkToken.isPresent()){
            token = RandomStringUtils.randomNumeric(5);
            checkToken = tokenPemilihRepository.findByTokenAndIdPeriode(token, idPeriode);
        }
        return token;
    }

    @Override
    public Boolean verifyAdmin(String securityCode) {
        Optional<Admin> signIn = adminRepository.findBySecurityCode(AES.encrypt(securityCode));
        return signIn.isPresent();
    }
}
