package com.pemilihan.rw.controller;

import com.pemilihan.rw.payload.Messages;
import com.pemilihan.rw.payload.ReqGenerateToken;
import com.pemilihan.rw.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping(value = "generate-token")
    public ResponseEntity<Messages> register(@RequestBody ReqGenerateToken req)  {
        Messages resp = new Messages();

        Boolean status = adminService.verifyAdmin(req.getSecurityCode());
        if(Boolean.TRUE.equals(status)){
            adminService.generateToken(1, req.getQtyToken());
            log.info("Generate Token Berhasil");
            resp.success();
            return ResponseEntity.ok().body(resp);
        }else{
            resp.setResponseCode(403);
            resp.setResponseMessage("Security Code Invalid");
            return  ResponseEntity.status(403).body(resp);
        }
    }
}
