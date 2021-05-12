package de.ksbrwsk.qrcode.model;

import org.apache.commons.lang3.StringUtils;

public class QrCodeSmsParser extends AbstractQrCodeParser {

    private final QrCodeSms qrCodeSms;

    public QrCodeSmsParser(QrCodeSms qrCodeSms) {
        this.qrCodeSms = qrCodeSms;
    }

    @Override
    public String parse() {
        StringBuilder buffer = new StringBuilder("sms:");
        buffer.append(this.qrCodeSms.getPhoneToBeEncoded());
        if (StringUtils.isNotEmpty(this.qrCodeSms.getMessageToBeEncoded())) {
            buffer.append("?sms_body=");
            buffer.append(StringUtils.replace(this.qrCodeSms.getMessageToBeEncoded(), " ", "%20"));
        }
        return buffer.toString();
    }
}
