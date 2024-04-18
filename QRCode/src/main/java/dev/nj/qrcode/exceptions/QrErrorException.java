package dev.nj.qrcode.exceptions;

public class QrErrorException extends RuntimeException {
    public QrErrorException(String message) {
        super(message);
    }
}
