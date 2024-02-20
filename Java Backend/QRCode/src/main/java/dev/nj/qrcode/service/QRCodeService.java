package dev.nj.qrcode.service;

import java.awt.image.BufferedImage;

public interface QRCodeService {
    String getHealth();

    BufferedImage getImage(int size, String type);
}
