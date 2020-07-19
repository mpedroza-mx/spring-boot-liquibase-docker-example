package com.mrk.medical.consultory.patientsservice.dto;

import java.io.Serializable;

public class ValidationErrorDto<T>  implements Serializable {
  private String object;
  private String field;
  private T rejectedValue;
  private String message;

  public String getObject() {
    return object;
  }

  public ValidationErrorDto<T> setObject(String object) {
    this.object = object;
    return this;
  }

  public String getField() {
    return field;
  }

  public ValidationErrorDto<T> setField(String field) {
    this.field = field;
    return this;
  }

  public T getRejectedValue() {
    return rejectedValue;
  }

  public ValidationErrorDto<T> setRejectedValue(T rejectedValue) {
    this.rejectedValue = rejectedValue;
    return this;
  }

  public String getMessage() {
    return message;
  }

  public ValidationErrorDto<T> setMessage(String message) {
    this.message = message;
    return this;
  }
}
