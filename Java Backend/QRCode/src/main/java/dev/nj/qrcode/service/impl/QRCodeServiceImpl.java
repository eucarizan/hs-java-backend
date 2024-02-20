package dev.nj.qrcode.service.impl;

import dev.nj.qrcode.service.QRCodeService;
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
    public BufferedImage getImage(int size, String type) {
        BufferedImage image = createImage(Color.WHITE, size);

        return image;
    }

    private static BufferedImage createImage(Color color, int size) {
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        g.setColor(color);
        g.fillRect(0, 0, size, size);
        g.dispose();

        return image;
    }
}
