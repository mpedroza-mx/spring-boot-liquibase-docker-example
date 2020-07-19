package com.mrk.medical.consultory.patientsservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@JsonInclude(Include.NON_NULL)
public class PatientDto implements Serializable {

  private Long id;
  private String firstName;
  private String lastName;
  private LocalDate dateOfBirth;
  private String email;
  private String phone;
  private String zipCode;
  private String gender;
  private LocalDateTime createDate;
  private LocalDateTime updateDate;
  private Long createBy;
  private Long updateBy;
  private String active;

  public Long getId() {
    return id;
  }

  public PatientDto setId(Long id) {
    this.id = id;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }

  public PatientDto setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public PatientDto setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public PatientDto setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public PatientDto setEmail(String email) {
    this.email = email;
    return this;
  }

  public String getPhone() {
    return phone;
  }

  public PatientDto setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public String getZipCode() {
    return zipCode;
  }

  public PatientDto setZipCode(String zipCode) {
    this.zipCode = zipCode;
    return this;
  }

  public String getGender() {
    return gender;
  }

  public PatientDto setGender(String gender) {
    this.gender = gender;
    return this;
  }

  public LocalDateTime getCreateDate() {
    return createDate;
  }

  public PatientDto setCreateDate(LocalDateTime createDate) {
    this.createDate = createDate;
    return this;
  }

  public LocalDateTime getUpdateDate() {
    return updateDate;
  }

  public PatientDto setUpdateDate(LocalDateTime updateDate) {
    this.updateDate = updateDate;
    return this;
  }

  public Long getCreateBy() {
    return createBy;
  }

  public PatientDto setCreateBy(Long createBy) {
    this.createBy = createBy;
    return this;
  }

  public Long getUpdateBy() {
    return updateBy;
  }

  public PatientDto setUpdateBy(Long updateBy) {
    this.updateBy = updateBy;
    return this;
  }

  public String getActive() {
    return active;
  }

  public PatientDto setActive(String active) {
    this.active = active;
    return this;
  }
}
