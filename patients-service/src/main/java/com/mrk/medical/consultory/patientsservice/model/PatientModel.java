package com.mrk.medical.consultory.patientsservice.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "patient")
@DynamicUpdate
public class PatientModel implements Serializable {

  @Id
  @Column(name = "id", updatable = false, nullable = false)
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long id;
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "last_name")
  private String lastName;
  @Column(name = "date_of_birth")
  private LocalDate dateOfBirth;
  @Column(name = "email")
  private String email;
  @Column(name = "phone")
  private String phone;
  @Column(name = "zip_code")
  private String zipCode;
  @Column(name = "gender")
  private String gender;
  @Column(name = "create_date", updatable = false, insertable = false)
  private LocalDateTime createDate;
  @Column(name = "update_date")
  private LocalDateTime updateDate;
  @Column(name = "create_by", updatable = false)
  private Long createBy;
  @Column(name = "update_by")
  private Long updateBy;
  @Column(name = "active")
  private String active;

  public Long getId() {
    return id;
  }

  public PatientModel setId(Long id) {
    this.id = id;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }

  public PatientModel setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public PatientModel setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public PatientModel setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public PatientModel setEmail(String email) {
    this.email = email;
    return this;
  }

  public String getPhone() {
    return phone;
  }

  public PatientModel setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public String getZipCode() {
    return zipCode;
  }

  public PatientModel setZipCode(String zipCode) {
    this.zipCode = zipCode;
    return this;
  }

  public String getGender() {
    return gender;
  }

  public PatientModel setGender(String gender) {
    this.gender = gender;
    return this;
  }

  public LocalDateTime getCreateDate() {
    return createDate;
  }

  public PatientModel setCreateDate(LocalDateTime createDate) {
    this.createDate = createDate;
    return this;
  }

  public LocalDateTime getUpdateDate() {
    return updateDate;
  }

  public PatientModel setUpdateDate(LocalDateTime updateDate) {
    this.updateDate = updateDate;
    return this;
  }

  public Long getCreateBy() {
    return createBy;
  }

  public PatientModel setCreateBy(Long createBy) {
    this.createBy = createBy;
    return this;
  }

  public Long getUpdateBy() {
    return updateBy;
  }

  public PatientModel setUpdateBy(Long updateBy) {
    this.updateBy = updateBy;
    return this;
  }

  public String getActive() {
    return active;
  }

  public PatientModel setActive(String active) {
    this.active = active;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    PatientModel that = (PatientModel) o;

    if (!id.equals(that.id)) {
      return false;
    }
    if (!firstName.equals(that.firstName)) {
      return false;
    }
    if (!lastName.equals(that.lastName)) {
      return false;
    }
    if (!dateOfBirth.equals(that.dateOfBirth)) {
      return false;
    }
    if (!email.equals(that.email)) {
      return false;
    }
    if (!phone.equals(that.phone)) {
      return false;
    }
    if (!zipCode.equals(that.zipCode)) {
      return false;
    }
    if (!gender.equals(that.gender)) {
      return false;
    }
    if (!createDate.equals(that.createDate)) {
      return false;
    }
    if (!updateDate.equals(that.updateDate)) {
      return false;
    }
    if (!createBy.equals(that.createBy)) {
      return false;
    }
    if (!updateBy.equals(that.updateBy)) {
      return false;
    }
    return active.equals(that.active);
  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + firstName.hashCode();
    result = 31 * result + lastName.hashCode();
    result = 31 * result + dateOfBirth.hashCode();
    result = 31 * result + email.hashCode();
    result = 31 * result + phone.hashCode();
    result = 31 * result + zipCode.hashCode();
    result = 31 * result + gender.hashCode();
    result = 31 * result + createDate.hashCode();
    result = 31 * result + updateDate.hashCode();
    result = 31 * result + createBy.hashCode();
    result = 31 * result + updateBy.hashCode();
    result = 31 * result + active.hashCode();
    return result;
  }
}
