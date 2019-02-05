package de.ksbrwsk.qrcode.model;

import org.apache.commons.lang3.StringUtils;

public class QrCodeUrlParser extends AbstractQrCodeParser {

    private final QrCodeUrl qrCodeUrl;

    public QrCodeUrlParser(QrCodeUrl qrCodeUrl) {
        this.qrCodeUrl = qrCodeUrl;
    }

    @Override
    public String parse() {
        return StringUtils.replace(this.qrCodeUrl.getUrlToBeEncoded(), " ", "%20");
    }
}
