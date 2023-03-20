package com.pemilihan.rw.service;

public interface AdminService {

    void generateToken(int idPeriode, int qtyToken);

    String checkToken(String token, int idPeriode);

    Boolean verifyAdmin(String securityCode);
}
