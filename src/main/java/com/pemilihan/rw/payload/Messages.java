/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pemilihan.rw.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pemilihan.rw.utility.Constant;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Riko
 */
@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Messages {
    private Integer responseCode;
    private String responseMessage;
    private Object data;

    public void success() {
        this.responseCode = Constant.OK;
        this.responseMessage = Constant.SUKSES;
    }
    public void invalidToken() {
        this.responseCode = Constant.FAILED;
        this.responseMessage = Constant.INVALID_TOKEN;
    }
    public Messages() {
    }

    public Messages(Integer responseCode, String responseMessage) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }
}
