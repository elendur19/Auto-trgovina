package hr.fer.ris.autotrgovina.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@Builder
public class ErrorDetails {
    private ZonedDateTime timestamp;
    private String message;
    private String details;
}
