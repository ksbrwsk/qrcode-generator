package de.ksbrwsk.qrcode.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;

@Getter
@Setter
@Validated
public class QrCodeEvent {
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime eventStart = LocalDateTime.now();
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime eventEnd = LocalDateTime.now();

    @NotEmpty
    private String summary = "";

    private String location = "";

    public QrCodeEvent(LocalDateTime eventStart, LocalDateTime eventEnd, String summary, String location) {
        this.eventStart = eventStart;
        this.eventEnd = eventEnd;
        this.summary = summary;
        this.location = location;
    }

    public QrCodeEvent() {
    }
}
