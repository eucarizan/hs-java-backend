package dev.nj.qrcode.service.impl;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import dev.nj.qrcode.service.QRCodeService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;

@Service
public class QRCodeServiceImpl implements QRCodeService {

    @Override
    public String getHealth() {
        return "";
    }

    @Override
    public BufferedImage getImage(int size, String contents) {
        if (size < 150 || size > 350) {
            return null;
        }

        return createImage(size, contents);
    }

    @Override
    public MediaType getType(String type) {
        if ("png".equalsIgnoreCase(type) || "jpeg".equalsIgnoreCase(type) || "gif".equalsIgnoreCase(type)) {
            return MediaType.parseMediaType("image/" + type);
        }

        return null;
    }

    private static BufferedImage createImage(int size, String contents) {
        QRCodeWriter writer = new QRCodeWriter();

        try {
            BitMatrix bitMatrix = writer.encode(contents, BarcodeFormat.QR_CODE, size, size);
            return MatrixToImageWriter.toBufferedImage(bitMatrix);
        } catch (WriterException e) {
            return null;
        }
    }
}
