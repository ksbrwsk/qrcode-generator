package de.ksbrwsk.qrcode.model;

import de.ksbrwsk.qrcode.utils.TestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BindingResult;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class QrCodeVCardTest {

    @Test
    public void thatQrCodeVCardIsValid() {
        QrCodeVCard qrCodeVCard = new QrCodeVCard();
        qrCodeVCard.setName("Chuck");
        qrCodeVCard.setLastname("Norris");
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodeVCard);
        assertFalse(bindingResult.hasErrors());
    }

    @Test
    public void thatQrCodeVCardIsNotValidNameNull() {
        QrCodeVCard qrCodeVCard = new QrCodeVCard();
        qrCodeVCard.setLastname("Norris");
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodeVCard);
        assertTrue(bindingResult.hasErrors());
    }

    @Test
    public void thatQrCodeVCardIsNotValidNameEmpty() {
        QrCodeVCard qrCodeVCard = new QrCodeVCard();
        qrCodeVCard.setLastname("Norris");
        qrCodeVCard.setName("");
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodeVCard);
        assertTrue(bindingResult.hasErrors());
    }

    @Test
    public void thatQrCodeVCardIsNotValidLastNameNull() {
        QrCodeVCard qrCodeVCard = new QrCodeVCard();
        qrCodeVCard.setName("Chuck");
        qrCodeVCard.setLastname(null);
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodeVCard);
        assertTrue(bindingResult.hasErrors());
    }

    @Test
    public void thatQrCodeVCardIsNotValidLastNameEmpty() {
        QrCodeVCard qrCodeVCard = new QrCodeVCard();
        qrCodeVCard.setLastname("");
        qrCodeVCard.setName("Chuck");
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodeVCard);
        assertTrue(bindingResult.hasErrors());
    }
}