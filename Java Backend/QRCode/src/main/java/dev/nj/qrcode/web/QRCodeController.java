package dev.nj.qrcode.web;

import dev.nj.qrcode.service.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Object> getImage(@RequestParam String contents, @RequestParam int size, @RequestParam String type) {
        if (contents.trim().isEmpty()) {
            return new ResponseEntity<>(Map.of("error", "Contents cannot be null or blank"), HttpStatus.BAD_REQUEST);
        }

        BufferedImage image = qrCodeService.getImage(size, contents);
        if (image == null) {
            return new ResponseEntity<>(Map.of("error", "Image size must be between 150 and 350 pixels"), HttpStatus.BAD_REQUEST);
        }

        MediaType mediaType = qrCodeService.getType(type);
        if (mediaType == null) {
            return new ResponseEntity<>(Map.of("error", "Only png, jpeg and gif image types are supported"), HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity
                .ok()
                .contentType(mediaType)
                .body(image);
    }
}
