package de.ksbrwsk.qrcode.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;

/**
 * Model for a calendar event QR code (iCalendar / VCALENDAR format).
 * <p>
 * The event start and end times default to the current hour and the next hour
 * respectively. Only {@code summary} is required.
 */
@Getter
@Setter
@Validated
public class QrCodeEvent {
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime eventStart = LocalDateTime.now().withMinute(0);
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime eventEnd = LocalDateTime.now().plusHours(1).withMinute(0);

    @NotEmpty
    private String summary = "";

    private String location = "";

    /**
     * Creates a new event instance with all fields specified.
     *
     * @param eventStart start date and time of the event
     * @param eventEnd   end date and time of the event
     * @param summary    short summary / title of the event
     * @param location   location of the event
     */
    public QrCodeEvent(LocalDateTime eventStart, LocalDateTime eventEnd, String summary, String location) {
        this.eventStart = eventStart;
        this.eventEnd = eventEnd;
        this.summary = summary;
        this.location = location;
    }

    public QrCodeEvent() {
    }
}
