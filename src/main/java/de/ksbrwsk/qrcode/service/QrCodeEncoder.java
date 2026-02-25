package de.ksbrwsk.qrcode.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import de.ksbrwsk.qrcode.model.*;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;
import java.util.Base64;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;
import java.util.UUID;

/**
 * Spring component that encodes various data types into QR code images.
 * <p>
 * Each {@code generateQrCode*()} method delegates payload formatting to the
 * corresponding {@code *Parser} and then renders a 250×250 px PNG image,
 * returning it as a Base64-encoded {@code data:image/png;base64,...} string
 * wrapped in a {@link QrCodeProcessingResult}.
 * <p>
 * ZXing encoding settings: UTF-8 character set, error correction level L, margin 1.
 */
@Component
@Slf4j
public class QrCodeEncoder {

    /**
     * Generates a QR code for a URL.
     *
     * @param qrCodeUrl the URL model
     * @return the processing result containing the Base64-encoded image
     */
    public QrCodeProcessingResult generateQrCodeUrl(QrCodeUrl qrCodeUrl) {
        String extracted = new QrCodeUrlParser(qrCodeUrl).parse();
        return this.generateImageAsBase64(extracted);
    }

    /**
     * Generates a QR code for an email address.
     *
     * @param qrCodeEmail the email model
     * @return the processing result containing the Base64-encoded image
     */
    public QrCodeProcessingResult generateQrCodeEmail(QrCodeEmail qrCodeEmail) {
        String extracted = new QrCodeEmailParser(qrCodeEmail).parse();
        return this.generateImageAsBase64(extracted);
    }

    /**
     * Generates a QR code for an SMS message.
     *
     * @param qrCodeSms the SMS model
     * @return the processing result containing the Base64-encoded image
     */
    public QrCodeProcessingResult generateQrCodeSms(QrCodeSms qrCodeSms) {
        String extracted = new QrCodeSmsParser(qrCodeSms).parse();
        return this.generateImageAsBase64(extracted);
    }

    /**
     * Generates a QR code for a phone number.
     *
     * @param qrCodePhone the phone model
     * @return the processing result containing the Base64-encoded image
     */
    public QrCodeProcessingResult generateQrCodePhone(QrCodePhone qrCodePhone) {
        String extracted = new QrCodePhoneParser(qrCodePhone).parse();
        return this.generateImageAsBase64(extracted);
    }

    /**
     * Generates a QR code for a calendar event.
     *
     * @param qrCodeEvent the event model
     * @return the processing result containing the Base64-encoded image
     */
    public QrCodeProcessingResult generateQrCodeEvent(QrCodeEvent qrCodeEvent) {
        String extracted = new QrCodeEventParser(qrCodeEvent).parse();
        return this.generateImageAsBase64(extracted);
    }

    /**
     * Generates a QR code for a FaceTime address or phone number.
     *
     * @param qrCodeFacetime the FaceTime model
     * @return the processing result containing the Base64-encoded image
     */
    public QrCodeProcessingResult generateQrCodeFacetime(QrCodeFacetime qrCodeFacetime) {
        String extracted = new QrCodeFacetimeParser(qrCodeFacetime).parse();
        return this.generateImageAsBase64(extracted);
    }

    /**
     * Generates a QR code for a vCard contact.
     *
     * @param qrCodeVCard the vCard model
     * @return the processing result containing the Base64-encoded image
     */
    public QrCodeProcessingResult generateQrCodeVCard(QrCodeVCard qrCodeVCard) {
        String extracted = new QrCodeVCardParser(qrCodeVCard).parse();
        return this.generateImageAsBase64(extracted);
    }

    /**
     * Encodes the given text as a QR code PNG image and returns it Base64-encoded.
     *
     * @param textToBeEncoded the payload string to encode
     * @return the processing result with the {@code data:image/png;base64,...} image string,
     *         or an error message if encoding fails
     */
    private QrCodeProcessingResult generateImageAsBase64(String textToBeEncoded) {
        QrCodeProcessingResult result = new QrCodeProcessingResult();
        result.setEncodedText(textToBeEncoded);
        String imageText = "";
        int size = 250;
        String fileType = "png";
        try {
            Map<EncodeHintType, Object> hintMap = createHintMap();
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(textToBeEncoded, BarcodeFormat.QR_CODE, size, size, hintMap);
            int width = bitMatrix.getWidth();
            int height = bitMatrix.getHeight();
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            image.createGraphics();
            Graphics2D graphics = (Graphics2D) image.getGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, width, height);
            graphics.setColor(Color.BLACK);
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < width; j++) {
                    if (bitMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }
            String fileName = UUID.randomUUID().toString();
            File myFile = File.createTempFile(fileName, "." + fileType);
            ImageIO.write(image, fileType, myFile);
            byte[] bytes = FileUtils.readFileToByteArray(myFile);
            imageText = "data:image/png;base64," +
                    Base64.getEncoder().encodeToString(bytes);
            result.setImage(imageText);
        } catch (WriterException | IOException e) {
            String msg = "Processing QR code failed.";
            log.error(msg, e);
            result.setErrorMessage(msg);
        }
        log.info("QR Code for text {} was successfully created.", textToBeEncoded);
        result.setSuccessMessage("QR Code was successfully created.");
        return result;
    }

    /**
     * Builds the ZXing hint map with UTF-8 character set, margin 1, and error correction level L.
     *
     * @return the hint map for the ZXing QR code writer
     */
    @NotNull
    private Map<EncodeHintType, Object> createHintMap() {
        Map<EncodeHintType, Object> hintMap = new EnumMap<>(EncodeHintType.class);
        hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hintMap.put(EncodeHintType.MARGIN, 1);
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        return hintMap;
    }

}
