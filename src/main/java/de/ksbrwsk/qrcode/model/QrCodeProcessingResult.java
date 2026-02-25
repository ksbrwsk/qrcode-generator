package de.ksbrwsk.qrcode.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Holds the outcome of a QR code encoding operation.
 * <p>
 * On success, {@link #image} contains a {@code data:image/png;base64,...} string and
 * {@link #successMessage} is set. On failure, {@link #errorMessage} is set instead.
 */
@Getter
@Setter
public class QrCodeProcessingResult {
    /** Base64-encoded PNG image as a data URI. */
    private String image;
    /** The payload string that was encoded into the QR code. */
    private String encodedText;
    /** Human-readable success message; non-null when encoding succeeded. */
    private String successMessage;
    /** Human-readable error message; non-null when encoding failed. */
    private String errorMessage;

    /**
     * Returns {@code true} if the QR code was generated successfully.
     *
     * @return {@code true} when {@link #successMessage} is set
     */
    public boolean isSuccessfull() {
        return successMessage != null;
    }
}
