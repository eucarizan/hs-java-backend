package dev.nj.qrcode.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Map;

@RestController
public class QRCodeController {

    private static final Map<String, BufferedImage> images = Map.of(
            "white", createImage(Color.WHITE)
    );

    @GetMapping("/health")
    public ResponseEntity<String> getHealth() {
        return ResponseEntity.ok("");
    }

    @GetMapping("/qrcode")
    public ResponseEntity<BufferedImage> getImage() {
        BufferedImage image = images.get("white");

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(image);
    }

    private static BufferedImage createImage(Color color) {
        BufferedImage image = new BufferedImage(250, 250, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        g.setColor(color);
        g.fillRect(0, 0, 250, 250);
        g.dispose();

        return image;
    }
}
