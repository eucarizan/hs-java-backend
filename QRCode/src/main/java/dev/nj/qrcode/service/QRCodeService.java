package dev.nj.qrcode.service;

import org.springframework.http.MediaType;

import java.awt.image.BufferedImage;

public interface QRCodeService {
    String getHealth();

    BufferedImage getImage(int size, String contents, String correction);

    MediaType getType(String type);
}
