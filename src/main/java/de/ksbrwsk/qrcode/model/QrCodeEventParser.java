package de.ksbrwsk.qrcode.model;

import java.time.format.DateTimeFormatter;

/**
 * Parser that formats a {@link QrCodeEvent} into an iCalendar (VCALENDAR) payload string.
 * <p>
 * Timestamps are formatted as {@code yyyyMMdd'T'HHmmss} in the Europe/Berlin time zone.
 */
public class QrCodeEventParser extends AbstractQrCodeParser {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss");

    private final QrCodeEvent qrCodeEvent;

    /**
     * Creates a new parser for the given event model.
     *
     * @param qrCodeEvent the event model to parse
     */
    public QrCodeEventParser(QrCodeEvent qrCodeEvent) {
        this.qrCodeEvent = qrCodeEvent;
    }

    /**
     * Formats the event data into a VCALENDAR/VEVENT payload string.
     *
     * @return the formatted iCalendar payload string
     */
    @Override
    public String parse() {
        String start = DATE_FORMATTER.format(qrCodeEvent.getEventStart());
        String end = DATE_FORMATTER.format(qrCodeEvent.getEventEnd());

        String eventText ="BEGIN:VCALENDAR\n"
                +"BEGIN:VEVENT\n"
                +"SUMMARY:"+qrCodeEvent.getSummary().replace('\n', ' ')+"\n"
                +"DTSTART;TZID=Europe/Berlin;VALUE=DATE-TIME:"+start+"\n"
                +"DTEND;TZID=Europe/Berlin;VALUE=DATE-TIME:"+end+"\n"
                +"LOCATION:"+qrCodeEvent.getLocation()+"\n"
                +"END:VEVENT\n"
                +"END:VCALENDAR";

        return eventText;
    }
}
