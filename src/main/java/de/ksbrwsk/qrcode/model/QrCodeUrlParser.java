package de.ksbrwsk.qrcode.model;

import org.apache.commons.lang3.StringUtils;

/**
 * Parser that formats a {@link QrCodeUrl} into its ZXing payload string.
 * <p>
 * Spaces in the URL are percent-encoded as {@code %20}.
 */
public class QrCodeUrlParser extends AbstractQrCodeParser {

    private final QrCodeUrl qrCodeUrl;

    /**
     * Creates a new parser for the given URL model.
     *
     * @param qrCodeUrl the URL model to parse
     */
    public QrCodeUrlParser(QrCodeUrl qrCodeUrl) {
        this.qrCodeUrl = qrCodeUrl;
    }

    /**
     * Returns the URL with spaces replaced by {@code %20}.
     *
     * @return the formatted URL payload string
     */
    @Override
    public String parse() {
        return StringUtils.replace(this.qrCodeUrl.getUrl(), " ", "%20");
    }
}
