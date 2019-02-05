package de.ksbrwsk.qrcode.service;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.EnumMap;
import java.util.Map;

@Component
@Slf4j
public class QrCodeDecoder {

    public String decodeQrCodeFile(File qrCodeFile) throws Exception {
        log.info("start decoding file {}", qrCodeFile.getName());
        BufferedImage bufferedImage = ImageIO.read(qrCodeFile);
        LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));
        Map<DecodeHintType, Object> hintMap = new EnumMap<>(DecodeHintType.class);
        hintMap.put(DecodeHintType.CHARACTER_SET, "UTF-8");
        hintMap.put(DecodeHintType.PURE_BARCODE, Void.class);
        Result result = new QRCodeReader().decode(binaryBitmap, hintMap);
        log.info("file {} successfully decoded", qrCodeFile.getName());
        return result.getText();
    }
}
