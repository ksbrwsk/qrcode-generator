package de.ksbrwsk.qrcode.model;

/**
 * Parser that formats a {@link QrCodePhone} into its ZXing payload string.
 * <p>
 * Produces a {@code tel:} URI, e.g. {@code tel:+12125551212}.
 */
public class QrCodePhoneParser extends AbstractQrCodeParser {

    private final QrCodePhone qrCodePhone;

    /**
     * Creates a new parser for the given phone model.
     *
     * @param qrCodePhone the phone model to parse
     */
    public QrCodePhoneParser(QrCodePhone qrCodePhone) {
        this.qrCodePhone = qrCodePhone;
    }

    /**
     * Formats the phone number into a {@code tel:} URI.
     *
     * @return the formatted phone payload string
     */
    @Override
    public String parse() {
        return "tel:" + this.qrCodePhone.getPhone();
    }
}
