package dev.nj.qrcode.service;

import org.springframework.http.MediaType;

import java.awt.image.BufferedImage;

public interface QRCodeService {
    String getHealth();
    BufferedImage getImage(int size);
    MediaType getType(String type);
}
