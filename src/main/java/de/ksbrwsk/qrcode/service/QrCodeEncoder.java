package de.ksbrwsk.qrcode.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import de.ksbrwsk.qrcode.model.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;
import java.util.UUID;

@Component
@Slf4j
public class QrCodeEncoder {

    private QrCodeProcessingResult generateImageAsBase64(String textToBeEncoded) {
        QrCodeProcessingResult result = new QrCodeProcessingResult();
        result.setEncodedText(textToBeEncoded);
        String imageText = "";
        int size = 250;
        String fileType = "png";
        try {
            Map<EncodeHintType, Object> hintMap = new EnumMap<>(EncodeHintType.class);
            hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            hintMap.put(EncodeHintType.MARGIN, 1);
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
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
                    Base64Utils.encodeToString(bytes);
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

    public QrCodeProcessingResult generateQrCodeUrl(QrCodeUrl qrCodeUrl) {
        String extracted = new QrCodeUrlParser(qrCodeUrl).parse();
        return this.generateImageAsBase64(extracted);
    }

    public QrCodeProcessingResult generateQrCodeEmail(QrCodeEmail qrCodeEmail) {
        String extracted = new QrCodeEmailParser(qrCodeEmail).parse();
        return this.generateImageAsBase64(extracted);
    }

    public QrCodeProcessingResult generateQrCodePhone(QrCodePhone qrCodePhone) {
        String extracted = new QrCodePhoneParser(qrCodePhone).parse();
        return this.generateImageAsBase64(extracted);
    }

    public QrCodeProcessingResult generateQrCodeVCard(QrCodeVCard qrCodeVCard) {
        String extracted = new QrCodeVCardParser(qrCodeVCard).parse();
        return this.generateImageAsBase64(extracted);
    }
}
