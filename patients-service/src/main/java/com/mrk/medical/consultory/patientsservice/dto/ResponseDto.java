package com.mrk.medical.consultory.patientsservice.dto;

import java.io.Serializable;
import java.util.List;

public class ResponseDto<T> implements Serializable {

  private T entity;
  private String status;
  private List<ErrorDto> errors;

  public T getEntity() {
    return entity;
  }

  public ResponseDto<T> setEntity(T entity) {
    this.entity = entity;
    return this;
  }

  public String getStatus() {
    return status;
  }

  public ResponseDto<T> setStatus(String status) {
    this.status = status;
    return this;
  }

  public List<ErrorDto> getErrors() {
    return errors;
  }

  public ResponseDto<T> setErrors(List<ErrorDto> errors) {
    this.errors = errors;
    return this;
  }
}
