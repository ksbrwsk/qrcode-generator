package de.ksbrwsk.qrcode.model;

public class QrCodePhoneParser extends AbstractQrCodeParser {

    private final QrCodePhone qrCodePhone;

    public QrCodePhoneParser(QrCodePhone qrCodePhone) {
        this.qrCodePhone = qrCodePhone;
    }

    @Override
    public String parse() {
        return "tel:" + this.qrCodePhone.getPhoneToBeEncoded();
    }
}
