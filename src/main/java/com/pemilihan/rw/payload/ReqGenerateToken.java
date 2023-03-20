package com.pemilihan.rw.payload;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ReqGenerateToken {
    private String securityCode;
    private int qtyToken;
}
