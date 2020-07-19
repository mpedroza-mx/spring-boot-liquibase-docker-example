package com.mrk.medical.consultory.patientsservice.exception;


import com.mrk.medical.consultory.patientsservice.dto.ErrorDto;
import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
  private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationExceptionHandler.class);

  protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(
      HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
    String errorMessage = "Unsupported Media Type";
    ErrorDto errorDto = new ErrorDto()
        .setErrorCode(status.name())
        .setErrorMessage(errorMessage)
        .setTimestamp(LocalDateTime.now());
    return buildResponseEntity(errorDto,ex, status);
  }

  protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
    String errorMessage = "Malformed JSON request";
    ErrorDto errorDto = new ErrorDto()
        .setErrorCode(status.name())
        .setErrorMessage(errorMessage)
        .setTimestamp(LocalDateTime.now());
    return buildResponseEntity(errorDto,ex, status);
  }

  private ResponseEntity<Object> buildResponseEntity(ErrorDto errorDto, Exception ex, HttpStatus status) {
    LOGGER.error(ex.getMessage(),ex);
    return new ResponseEntity<>(errorDto, status);
  }
}
