package com.pemilihan.rw.utility;

import jakarta.servlet.http.HttpServletResponse;

public class Constant {

    private Constant() {}


    public static final String AUTH = "Authorization";
    public  static final String ENCRYPT_KEY = "P3m!lih@4anRW01!";
    public static final String AUTH_KEY = "Pemilihan RW 01 Babakan Regol 2023";
    public static final String SUKSES = "Sukses";
    public static final String GAGAL = "Proses Gagal";
    public static final String INVALID_TOKEN = "Token tidak berlaku lagi";
    public static final Integer OK = HttpServletResponse.SC_OK;
    public static final Integer FAILED = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;

}
