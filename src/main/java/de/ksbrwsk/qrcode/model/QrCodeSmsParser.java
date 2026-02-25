package de.ksbrwsk.qrcode.model;

import org.apache.commons.lang3.StringUtils;

/**
 * Parser that formats a {@link QrCodeSms} into its ZXing payload string.
 * <p>
 * Produces a {@code sms:} URI, appending a percent-encoded {@code ?sms_body=}
 * parameter when a message body is present.
 */
public class QrCodeSmsParser extends AbstractQrCodeParser {

    private final QrCodeSms qrCodeSms;

    /**
     * Creates a new parser for the given SMS model.
     *
     * @param qrCodeSms the SMS model to parse
     */
    public QrCodeSmsParser(QrCodeSms qrCodeSms) {
        this.qrCodeSms = qrCodeSms;
    }

    /**
     * Formats the phone number and optional message body into a {@code sms:} URI.
     *
     * @return the formatted SMS payload string
     */
    @Override
    public String parse() {
        StringBuilder buffer = new StringBuilder("sms:");
        buffer.append(this.qrCodeSms.getPhone());
        if (StringUtils.isNotEmpty(this.qrCodeSms.getMessageToBeEncoded())) {
            buffer.append("?sms_body=");
            buffer.append(StringUtils.replace(this.qrCodeSms.getMessageToBeEncoded(), " ", "%20"));
        }
        return buffer.toString();
    }
}
