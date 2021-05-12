package de.ksbrwsk.qrcode.model;

import de.ksbrwsk.qrcode.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BindingResult;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QrCodeUrlTest {

    @Test
    public void thatQrCodeUrlIsValid() {
        QrCodeUrl qrCodeUrl = new QrCodeUrl("http://www.google.de");
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodeUrl);
        assertFalse(bindingResult.hasErrors());
    }

    @Test
    public void thatQrCodeUrlIsValidSetter() {
        QrCodeUrl qrCodeUrl = new QrCodeUrl();
        qrCodeUrl.setUrlToBeEncoded("http://www.google.de");
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodeUrl);
        assertFalse(bindingResult.hasErrors());
    }

    @Test
    public void thatQrCodeUrlIsNotValidNull() {
        QrCodeUrl qrCodeUrl = new QrCodeUrl(null);
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodeUrl);
        assertTrue(bindingResult.hasErrors());
    }

    @Test
    public void thatQrCodeUrlIsNotValidEmpty() {
        QrCodeUrl qrCodeUrl = new QrCodeUrl("");
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodeUrl);
        assertTrue(bindingResult.hasErrors());
    }
}