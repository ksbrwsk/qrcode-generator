package de.ksbrwsk.qrcode.model;

/**
 * Parser that formats a {@link QrCodeFacetime} into its ZXing payload string.
 * <p>
 * Produces a {@code facetime://} URI, e.g. {@code facetime://+12125551212}.
 */
public class QrCodeFacetimeParser extends AbstractQrCodeParser {

    private final QrCodeFacetime qrCodeFacetime;

    /**
     * Creates a new parser for the given FaceTime model.
     *
     * @param qrCodeFacetime the FaceTime model to parse
     */
    public QrCodeFacetimeParser(QrCodeFacetime qrCodeFacetime) {
        this.qrCodeFacetime = qrCodeFacetime;
    }

    /**
     * Formats the FaceTime address into a {@code facetime://} URI.
     *
     * @return the formatted FaceTime payload string
     */
    @Override
    public String parse() {
        return "facetime://" + this.qrCodeFacetime.getFacetime();
    }
}
