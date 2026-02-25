package de.ksbrwsk.qrcode.model;

import org.apache.commons.lang3.StringUtils;

/**
 * Parser that formats a {@link QrCodeEmail} into its ZXing payload string.
 * <p>
 * Produces a {@code mailto:} URI, appending a percent-encoded {@code ?subject=}
 * parameter when a subject is present.
 */
public class QrCodeEmailParser extends AbstractQrCodeParser {

    private final QrCodeEmail qrCodeEmail;

    /**
     * Creates a new parser for the given email model.
     *
     * @param qrCodeEmail the email model to parse
     */
    public QrCodeEmailParser(QrCodeEmail qrCodeEmail) {
        this.qrCodeEmail = qrCodeEmail;
    }

    /**
     * Formats the email and optional subject into a {@code mailto:} URI.
     *
     * @return the formatted email payload string
     */
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
