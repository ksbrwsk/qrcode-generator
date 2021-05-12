package de.ksbrwsk.qrcode.model;

import de.ksbrwsk.qrcode.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BindingResult;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QrCodeFacetimeTest {

    @Test
    public void thatQrCodeFacetimeIsValid() {
        QrCodeFacetime qrCodeFacetime = new QrCodeFacetime("+1 555 1234567");
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodeFacetime);
        assertFalse(bindingResult.hasErrors());
    }

    @Test
    public void thatQrCodeFacetimeIsValidSetter() {
        QrCodeFacetime qrCodeFacetime = new QrCodeFacetime();
        qrCodeFacetime.setFacetimeToBeEncoded("+1 555 1234567");
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodeFacetime);
        assertFalse(bindingResult.hasErrors());
    }

    @Test
    public void thatQrCodeFacetimeIsNotValidNull() {
        QrCodeFacetime qrCodeFacetime = new QrCodeFacetime();
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodeFacetime);
        assertTrue(bindingResult.hasErrors());
    }

    @Test
    public void thatQrCodeFacetimeIsNotValidEmpty() {
        QrCodeFacetime qrCodeFacetime = new QrCodeFacetime("");
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodeFacetime);
        assertTrue(bindingResult.hasErrors());
    }
}