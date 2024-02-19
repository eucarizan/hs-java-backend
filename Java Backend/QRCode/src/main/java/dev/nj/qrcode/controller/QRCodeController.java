package dev.nj.qrcode.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QRCodeController {

    @GetMapping("/health")
    public ResponseEntity<String> getHealth() {
        return ResponseEntity.ok("");
    }

    @GetMapping("/qrcode")
    public ResponseEntity<String> getQR() {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("");
    }
}
