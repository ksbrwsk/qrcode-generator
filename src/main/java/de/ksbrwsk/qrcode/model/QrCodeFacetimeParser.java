package de.ksbrwsk.qrcode.model;

public class QrCodeFacetimeParser extends AbstractQrCodeParser {

    private final QrCodeFacetime qrCodeFacetime;

    public QrCodeFacetimeParser(QrCodeFacetime qrCodeFacetime) {
        this.qrCodeFacetime = qrCodeFacetime;
    }

    @Override
    public String parse() {
        return "facetime://" + this.qrCodeFacetime.getFacetimeToBeEncoded();
    }
}
