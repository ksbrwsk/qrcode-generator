package de.ksbrwsk.qrcode.model;

import de.ksbrwsk.qrcode.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BindingResult;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for {@link QrCodeEmail} bean validation.
 */
public class QrCodeEmailTest {

    @Test
    public void thatQrCodeMailIsValid() {
        QrCodeEmail qrCodeEmail = new QrCodeEmail("email@email.com");
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodeEmail);
        assertFalse(bindingResult.hasErrors());
    }

    @Test
    public void thatQrCodeMailIsValidSetter() {
        QrCodeEmail qrCodeEmail = new QrCodeEmail();
        qrCodeEmail.setEmail("email@email.com");
        qrCodeEmail.setSubject("My Subject");
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodeEmail);
        assertFalse(bindingResult.hasErrors());
    }

    @Test
    public void thatQrCodeMailIsNotValidNull() {
        QrCodeEmail qrCodeEmail = new QrCodeEmail(null);
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodeEmail);
        assertTrue(bindingResult.hasErrors());
    }

    @Test
    public void thatQrCodeMailIsNotValidEmpty() {
        QrCodeEmail qrCodeEmail = new QrCodeEmail("");
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodeEmail);
        assertTrue(bindingResult.hasErrors());
    }
}