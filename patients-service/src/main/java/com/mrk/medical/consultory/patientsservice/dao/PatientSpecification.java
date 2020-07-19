package com.mrk.medical.consultory.patientsservice.dao;

import com.mrk.medical.consultory.patientsservice.model.PatientModel;
import java.time.LocalDateTime;
import org.springframework.data.jpa.domain.Specification;

public class PatientSpecification {

  public static Specification<PatientModel> hasId(Long id) {
    return (model, cq, cb) -> cb.equal(model.get("id"), id);
  }

  public static Specification<PatientModel> hasFirstName(String firstName) {
    return (model, cq, cb) -> cb.equal(model.get("firstName"), firstName);
  }

  public static Specification<PatientModel> hasLastName(String lastName) {
    return (model, cq, cb) -> cb.equal(model.get("lastName"), lastName);
  }

  public static Specification<PatientModel> hasDateOfBirth(LocalDateTime dateOfBirth) {
    return (model, cq, cb) -> cb.equal(model.get("dateOfBirth"),dateOfBirth);
  }

  public static Specification<PatientModel> hasEmail(String email) {
    return (model, cq, cb) -> cb.equal(model.get("email"), email);
  }

  public static Specification<PatientModel> hasPhone(String phone) {
    return (model, cq, cb) -> cb.equal(model.get("phone"), phone);
  }

  public static Specification<PatientModel> hasZipCode(String zipCode) {
    return (model, cq, cb) -> cb.equal(model.get("zipCode"), zipCode);
  }

  public static Specification<PatientModel> hasGender(String gender) {
    return (model, cq, cb) -> cb.equal(model.get("gender"), gender);
  }

  public static Specification<PatientModel> hasCreatedDate(LocalDateTime createdDate) {
    return (model, cq, cb) -> cb.equal(model.get("createdDate"), createdDate);
  }

  public static Specification<PatientModel> hasUpdateDate(LocalDateTime updateDate) {
    return (model, cq, cb) -> cb.equal(model.get("updateDate"), updateDate);
  }

  public static Specification<PatientModel> hasCreatedBy(Long createdBy) {
    return (model, cq, cb) -> cb.equal(model.get("createdBy"), createdBy);
  }

  public static Specification<PatientModel> hasUpdatedBy(Long updatedBy) {
    return (model, cq, cb) -> cb.equal(model.get("updatedBy"), updatedBy);
  }

  public static Specification<PatientModel> hasActive(String active) {
    return (model, cq, cb) -> cb.equal(model.get("active"), active);
  }
}
