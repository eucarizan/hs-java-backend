package dev.nj.qrcode.web;

import dev.nj.qrcode.exceptions.QrErrorException;
import dev.nj.qrcode.service.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;
import java.util.Map;

@RestController
public class QRCodeController {

    private final QRCodeService qrCodeService;

    @Autowired
    public QRCodeController(QRCodeService qrCodeService) {
        this.qrCodeService = qrCodeService;
    }

    @GetMapping("/health")
    public ResponseEntity<String> getHealth() {
        return ResponseEntity.ok(qrCodeService.getHealth());
    }

    @GetMapping("/qrcode")
    public ResponseEntity<Object> getImage(
            @RequestParam String contents,
            @RequestParam(required = false, defaultValue = "250") int size,
            @RequestParam(required = false, defaultValue = "png") String type,
            @RequestParam(required = false, defaultValue = "L") String correction) {
        BufferedImage image = qrCodeService.getImage(size, contents, correction);
        MediaType mediaType = qrCodeService.getType(type);

        return ResponseEntity
                .ok()
                .contentType(mediaType)
                .body(image);
    }

    @ExceptionHandler(QrErrorException.class)
    ResponseEntity<Object> handleTicketException(QrErrorException ex) {
        return new ResponseEntity<>(Map.of("error", ex.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
