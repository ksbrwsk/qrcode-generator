package de.ksbrwsk.qrcode.model;

import de.ksbrwsk.qrcode.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BindingResult;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QrCodeSmsTest {

    @Test
    public void thatQrCodeSmsIsValid() {
        QrCodeSms qrCodeSms = new QrCodeSms("+49123456789");
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodeSms);
        assertFalse(bindingResult.hasErrors());
    }

    @Test
    public void thatQrCodeSmsIsValidSetter() {
        QrCodeSms qrCodeSms = new QrCodeSms();
        qrCodeSms.setPhoneToBeEncoded("+49123456789");
        qrCodeSms.setMessageToBeEncoded("My Test");
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodeSms);
        assertFalse(bindingResult.hasErrors());
    }

    @Test
    public void thatQrCodeSmsIsNotValidNull() {
        QrCodeSms qrCodeSms = new QrCodeSms(null);
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodeSms);
        assertTrue(bindingResult.hasErrors());
    }

    @Test
    public void thatQrCodeSmsIsNotValidEmpty() {
        QrCodeSms qrCodeSms = new QrCodeSms("");
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodeSms);
        assertTrue(bindingResult.hasErrors());
    }
}
