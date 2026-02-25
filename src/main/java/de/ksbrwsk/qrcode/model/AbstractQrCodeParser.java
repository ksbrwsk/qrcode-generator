package de.ksbrwsk.qrcode.model;

/**
 * Abstract base class for all QR code payload parsers.
 * <p>
 * Subclasses implement {@link #parse()} to format the ZXing-compatible payload string
 * for their specific data type (URL, email, phone, etc.).
 */
public abstract class AbstractQrCodeParser {

    /**
     * Formats the model data into a ZXing-compatible payload string.
     *
     * @return the encoded payload string
     */
    public abstract String parse();
}
