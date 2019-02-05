package de.ksbrwsk.qrcode.web;

import de.ksbrwsk.qrcode.model.QrCodeUrl;
import de.ksbrwsk.qrcode.model.QrCodeVCard;
import de.ksbrwsk.qrcode.model.QrCodeEmail;
import de.ksbrwsk.qrcode.model.QrCodePhone;
import de.ksbrwsk.qrcode.utils.TestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BindingResult;
import org.springframework.validation.support.BindingAwareModelMap;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class QrCodeControllerTests {

    @Autowired
    QrCodeController qrCodeController;

    @Test
    public void thatIndexPasses() {
        String expected = "index";
        String actual = this.qrCodeController.index(TestUtils.createModel());
        assertEquals(expected, actual);
    }

    @Test
    public void thatQrCodeUrlPasses() {
        String expected = "qr-code-url";
        BindingAwareModelMap model = TestUtils.createModel();
        String actual = this.qrCodeController.qrCodeUrl(model);
        assertEquals(expected, actual);
        assertNotNull(model.get("qrCodeUrl"));
    }

    @Test
    public void thatProcessQrCodeUrlPasses() {
        String expected = "result";
        QrCodeUrl qrCodeUrl = new QrCodeUrl("http://www.google.com");
        BindingAwareModelMap model = TestUtils.createModel();
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodeUrl);
        String actual = this.qrCodeController.processUrl(model, qrCodeUrl, bindingResult);
        assertEquals(expected, actual);
        assertNotNull(model.get("image"));
        assertNotNull(model.get("qrCodeUrl"));
    }

    @Test
    public void thatProcessQrCodeUrlFails() {
        String expected = "qr-code-url";
        QrCodeUrl qrCodeUrl = new QrCodeUrl("");
        BindingAwareModelMap model = TestUtils.createModel();
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodeUrl);
        String actual = this.qrCodeController.processUrl(model, qrCodeUrl, bindingResult);
        assertEquals(expected, actual);
        assertNull(model.get("image"));
        assertNotNull(model.get("qrCodeUrl"));
    }

    @Test
    public void thatProcessQrCodePhonePasses() {
        String expected = "result";
        QrCodePhone qrCodePhone = new QrCodePhone("+15551234567");
        BindingAwareModelMap model = TestUtils.createModel();
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodePhone);
        String actual = this.qrCodeController.processPhone(model, qrCodePhone, bindingResult);
        assertEquals(expected, actual);
        assertNotNull(model.get("image"));
        assertNotNull(model.get("qrCodePhone"));
    }

    @Test
    public void thatProcessQrCodePhoneFails() {
        String expected = "qr-code-phone";
        QrCodePhone qrCodePhone = new QrCodePhone("");
        BindingAwareModelMap model = TestUtils.createModel();
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodePhone);
        String actual = this.qrCodeController.processPhone(model, qrCodePhone, bindingResult);
        assertEquals(expected, actual);
        assertNull(model.get("image"));
        assertNotNull(model.get("qrCodePhone"));
    }

    @Test
    public void thatQrCodePhonePasses() {
        String expected = "qr-code-phone";
        BindingAwareModelMap model = TestUtils.createModel();
        String actual = this.qrCodeController.qrCodePhone(model);
        assertEquals(expected, actual);
        assertNotNull(model.get("qrCodePhone"));
    }

    @Test
    public void thatProcessQrCodeEmailPasses() {
        String expected = "result";
        QrCodeEmail qrCodeEmail = new QrCodeEmail("email@email.com");
        BindingAwareModelMap model = TestUtils.createModel();
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodeEmail);
        String actual = this.qrCodeController.processEmail(model, qrCodeEmail, bindingResult);
        assertEquals(expected, actual);
        assertNotNull(model.get("image"));
        assertNotNull(model.get("qrCodeEmail"));
    }

    @Test
    public void thatProcessQrCodeEmailFails() {
        String expected = "qr-code-email";
        QrCodeEmail qrCodeEmail = new QrCodeEmail("");
        BindingAwareModelMap model = TestUtils.createModel();
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodeEmail);
        String actual = this.qrCodeController.processEmail(model, qrCodeEmail, bindingResult);
        assertEquals(expected, actual);
        assertNull(model.get("image"));
        assertNotNull(model.get("qrCodeEmail"));
    }

    @Test
    public void thatQrCodeEmailPasses() {
        String expected = "qr-code-email";
        BindingAwareModelMap model = TestUtils.createModel();
        String actual = this.qrCodeController.qrCodeEmail(model);
        assertEquals(expected, actual);
        assertNotNull(model.get("qrCodeEmail"));
    }

    @Test
    public void thatProcessQrCodeVCardPasses() {
        String expected = "result";
        QrCodeVCard qrCodeVCard = new QrCodeVCard();
        qrCodeVCard.setName("Name");
        qrCodeVCard.setLastname("Lastname");
        BindingAwareModelMap model = TestUtils.createModel();
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodeVCard);
        String actual = this.qrCodeController.processVCard(model, qrCodeVCard, bindingResult);
        assertEquals(expected, actual);
        assertNotNull(model.get("image"));
        assertNotNull(model.get("qrCodeVCard"));
    }

    @Test
    public void thatProcessQrCodeVCardFails() {
        String expected = "qr-code-vcard";
        QrCodeVCard qrCodeVCard = new QrCodeVCard();
        qrCodeVCard.setName("");
        qrCodeVCard.setLastname("");
        BindingAwareModelMap model = TestUtils.createModel();
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodeVCard);
        String actual = this.qrCodeController.processVCard(model, qrCodeVCard, bindingResult);
        assertEquals(expected, actual);
        assertNull(model.get("image"));
        assertNotNull(model.get("qrCodeVCard"));
    }

    @Test
    public void thatQrCodeVCardPasses() {
        String expected = "qr-code-vcard";
        BindingAwareModelMap model = TestUtils.createModel();
        String actual = this.qrCodeController.qrCodeVCard(model);
        assertEquals(expected, actual);
        assertNotNull(model.get("qrCodeVCard"));
    }
}