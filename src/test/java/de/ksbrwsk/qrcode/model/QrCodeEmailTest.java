package de.ksbrwsk.qrcode.model;

import de.ksbrwsk.qrcode.utils.TestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BindingResult;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class QrCodeEmailTest {

    @Test
    public void thatQrCodeMailIsValid() {
        QrCodeEmail qrCodeEmail = new QrCodeEmail("http://www.google.com");
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodeEmail);
        assertFalse(bindingResult.hasErrors());
    }

    @Test
    public void thatQrCodeMailIsValidSetter() {
        QrCodeEmail qrCodeEmail = new QrCodeEmail();
        qrCodeEmail.setEmailToBeEncoded("http://www.google.com");
        qrCodeEmail.setSubjectToBeEncoded("My Subject");
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