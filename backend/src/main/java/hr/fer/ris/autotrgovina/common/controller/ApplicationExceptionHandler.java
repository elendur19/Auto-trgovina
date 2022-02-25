package hr.fer.ris.autotrgovina.common.controller;

import hr.fer.ris.autotrgovina.common.model.ErrorDetails;
import hr.fer.ris.autotrgovina.exception.ManufacturerNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.ZonedDateTime;
import java.util.Locale;

@RestControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class ApplicationExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public final ErrorDetails handleAllExceptions(Exception ex, WebRequest request) {
        log.error("Exception occurred:", ex);
        return ErrorDetails.builder()
                .timestamp(ZonedDateTime.now())
                .message(request.getDescription(false))
                .details(ex.getMessage())
                .build();
    }

    @ExceptionHandler(ManufacturerNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final ErrorDetails handleManufacturerNotFound(ManufacturerNotFoundException ex) {
        log.error("Exception occured:", ex);
        return errorResponse(ex, "exception.manufacturerNotFound.message");
    }

    private ErrorDetails errorResponse(RuntimeException ex, String messageKey) {
        return ErrorDetails.builder()
                .timestamp(ZonedDateTime.now())
                .message(ex.getClass().getSimpleName())
                .details(i18n(messageKey))
                .build();
    }

    private String i18n(String key) {
        return messageSource.getMessage(key, new Object[0], Locale.getDefault());
    }

}
