package de.ksbrwsk.qrcode.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QrCodeSmsParserTests {

    @Test
    public void thatParseSmsPasses() {
        String expected = "sms:+49123456789";
        QrCodeSms qrCodeSms = new QrCodeSms();
        qrCodeSms.setPhoneToBeEncoded("+49123456789");
        assertEquals(new QrCodeSmsParser(qrCodeSms).parse(), expected);
    }

    @Test
    public void thatParseSmsAndMessagePasses() {
        String expected = "sms:+49123456789?sms_body=My%20Test";
        QrCodeSms qrCodeSms = new QrCodeSms();
        qrCodeSms.setPhoneToBeEncoded("+49123456789");
        qrCodeSms.setMessageToBeEncoded("My Test");
        assertEquals(new QrCodeSmsParser(qrCodeSms).parse(), expected);
    }
}
