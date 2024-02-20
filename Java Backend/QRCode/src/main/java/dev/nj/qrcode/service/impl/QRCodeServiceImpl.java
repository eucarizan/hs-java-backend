package dev.nj.qrcode.service.impl;

import dev.nj.qrcode.service.QRCodeService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.image.BufferedImage;

@Service
public class QRCodeServiceImpl implements QRCodeService {

    @Override
    public String getHealth() {
        return "";
    }

    @Override
    public BufferedImage getImage(int size) {
        if (size < 150 || size > 350) {
            return null;
        }

        return createImage(size);
    }

    @Override
    public MediaType getType(String type) {
        if ("png".equalsIgnoreCase(type) || "jpeg".equalsIgnoreCase(type) || "gif".equalsIgnoreCase(type)) {
            return MediaType.parseMediaType("image/"+type);
        }

        return null;
    }

    private static BufferedImage createImage(int size) {
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, size, size);
        g.dispose();

        return image;
    }
}
