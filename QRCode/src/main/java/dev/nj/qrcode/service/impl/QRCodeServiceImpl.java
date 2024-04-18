package dev.nj.qrcode.service.impl;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import dev.nj.qrcode.exceptions.QrErrorException;
import dev.nj.qrcode.service.QRCodeService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.util.Map;

@Service
public class QRCodeServiceImpl implements QRCodeService {

    @Override
    public String getHealth() {
        return "";
    }

    @Override
    public BufferedImage getImage(int size, String contents, String correction) {
        if (contents.trim().isEmpty()) {
            throw new QrErrorException("Contents cannot be null or blank");
        }

        if (size < 150 || size > 350) {
            throw new QrErrorException("Image size must be between 150 and 350 pixels");
        }

        if (!"L".equals(correction) && !"M".equals(correction) && !"Q".equals(correction) && !"H".equals(correction)) {
            throw new QrErrorException("Permitted error correction levels are L, M, Q, H");
        }

        return createImage(size, contents, correction);
    }

    @Override
    public MediaType getType(String type) {
        if ("png".equalsIgnoreCase(type) || "jpeg".equalsIgnoreCase(type) || "gif".equalsIgnoreCase(type)) {
            return MediaType.parseMediaType("image/" + type);
        }

        throw new QrErrorException("Only png, jpeg and gif image types are supported");
    }

    private static BufferedImage createImage(int size, String contents, String correction) {
        QRCodeWriter writer = new QRCodeWriter();
        Map<EncodeHintType, ?> hints = Map.of(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.valueOf(correction));

        try {
            BitMatrix bitMatrix = writer.encode(contents, BarcodeFormat.QR_CODE, size, size, hints);
            return MatrixToImageWriter.toBufferedImage(bitMatrix);
        } catch (WriterException e) {
            return null;
        }
    }
}
