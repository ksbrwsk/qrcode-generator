package de.ksbrwsk.qrcode.model;

import org.apache.commons.lang3.StringUtils;

public class QrCodeEmailParser extends AbstractQrCodeParser {

    private final QrCodeEmail qrCodeEmail;

    public QrCodeEmailParser(QrCodeEmail qrCodeEmail) {
        this.qrCodeEmail = qrCodeEmail;
    }

    @Override
    public String parse() {
        StringBuilder buffer = new StringBuilder("mailto:");
        buffer.append(this.qrCodeEmail.getEmail());
        if (StringUtils.isNotEmpty(this.qrCodeEmail.getSubject())) {
            buffer.append("?subject=");
            buffer.append(StringUtils.replace(this.qrCodeEmail.getSubject(), " ", "%20"));
        }
        return buffer.toString();
    }
}
