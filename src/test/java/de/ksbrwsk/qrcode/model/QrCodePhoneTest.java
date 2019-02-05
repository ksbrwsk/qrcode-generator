package de.ksbrwsk.qrcode.model;

import de.ksbrwsk.qrcode.utils.TestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BindingResult;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class QrCodePhoneTest {

    @Test
    public void thatQrCodePhoneIsValid() {
        QrCodePhone qrCodePhone = new QrCodePhone("+1 555 1234567");
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodePhone);
        assertFalse(bindingResult.hasErrors());
    }

    @Test
    public void thatQrCodePhoneIsValidSetter() {
        QrCodePhone qrCodePhone = new QrCodePhone();
        qrCodePhone.setPhoneToBeEncoded("+1 555 1234567");
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodePhone);
        assertFalse(bindingResult.hasErrors());
    }

    @Test
    public void thatQrCodePhoneIsNotValidNull() {
        QrCodePhone qrCodePhone = new QrCodePhone();
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodePhone);
        assertTrue(bindingResult.hasErrors());
    }

    @Test
    public void thatQrCodePhoneIsNotValidEmpty() {
        QrCodePhone qrCodePhone = new QrCodePhone("");
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodePhone);
        assertTrue(bindingResult.hasErrors());
    }
}