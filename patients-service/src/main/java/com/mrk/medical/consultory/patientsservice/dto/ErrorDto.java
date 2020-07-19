package com.mrk.medical.consultory.patientsservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(Include.NON_NULL)
public class ErrorDto implements Serializable {

  private LocalDateTime timestamp;
  private String errorCode;
  private String errorMessage;
  private List<ValidationErrorDto> validationErrors;

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public ErrorDto setTimestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public ErrorDto setErrorCode(String errorCode) {
    this.errorCode = errorCode;
    return this;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public ErrorDto setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
    return this;
  }

  public List<ValidationErrorDto> getValidationErrors() {
    return validationErrors;
  }

  public ErrorDto setValidationErrors(
      List<ValidationErrorDto> validationErrors) {
    this.validationErrors = validationErrors;
    return this;
  }
}
