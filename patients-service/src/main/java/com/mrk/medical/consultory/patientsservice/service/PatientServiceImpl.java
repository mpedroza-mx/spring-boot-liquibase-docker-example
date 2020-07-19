package com.mrk.medical.consultory.patientsservice.service;


import static com.mrk.medical.consultory.patientsservice.dao.PatientSpecification.hasId;

import com.mrk.medical.consultory.patientsservice.dao.FiltersBuilder;
import com.mrk.medical.consultory.patientsservice.dao.PatientRepository;
import com.mrk.medical.consultory.patientsservice.dto.PatientDto;
import com.mrk.medical.consultory.patientsservice.model.PatientModel;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

  private PatientRepository patientRepository;
  private FiltersBuilder filtersBuilder;
  private static final String ACTIVE_STATUS = "y";

  @Autowired
  public PatientServiceImpl(final PatientRepository patientRepository, FiltersBuilder filtersBuilder) {
    this.patientRepository = patientRepository;
    this.filtersBuilder = filtersBuilder;
  }

  @Override
  public List<PatientDto> findAllPatients(Map<String, String> fields)
      throws InvocationTargetException, IllegalAccessException {
    List<PatientDto> patients = null;
    if (Optional.of(fields).isPresent() && fields.size() > 0) {
      List<PatientModel> models = patientRepository.findAll(filtersBuilder.buildSpecification(fields,null));
      patients = models
          .stream()
          .map(model -> fromPatientModelToDto(model))
          .collect(Collectors.toList());
      return patients;
    } else {
      patients = patientRepository.findAll().stream()
          .map(model -> fromPatientModelToDto(model))
          .collect(Collectors.toList());
      return patients;
    }
  }

  @Override
  public PatientDto findPatientById(long patientId) {
    List<PatientModel> result = patientRepository.findAll((hasId(patientId)));
    PatientDto patientDto = null;
    if (!result.isEmpty()) {
      PatientModel model = result.get(0);
      patientDto = fromPatientModelToDto(model);
    }
    return patientDto;
  }

  @Override
  public long createPatient(PatientDto patientDto) {
    patientDto.setActive(ACTIVE_STATUS);
    PatientModel model = fromPatientDtoToModel(patientDto);
    PatientModel newPatient = patientRepository.save(model);
    return newPatient.getId();
  }

  @Override
  public long updatePatient(long patientId, PatientDto patientDtoFromRequest) {
    PatientDto patientFromDb = findPatientById(patientId);
    if (patientDtoFromRequest.getZipCode() != null) {
      patientFromDb.setZipCode(patientDtoFromRequest.getZipCode());
    }
    if (patientDtoFromRequest.getDateOfBirth() != null) {
      patientFromDb.setDateOfBirth(patientDtoFromRequest.getDateOfBirth());
    }
    if (patientDtoFromRequest.getEmail() != null) {
      patientFromDb.setDateOfBirth(patientDtoFromRequest.getDateOfBirth());
    }
    if (patientDtoFromRequest.getFirstName() != null) {
      patientFromDb.setFirstName(patientDtoFromRequest.getFirstName());
    }
    if (patientDtoFromRequest.getLastName() != null) {
      patientFromDb.setLastName(patientDtoFromRequest.getLastName());
    }
    if (patientDtoFromRequest.getDateOfBirth() != null) {
      patientFromDb.setDateOfBirth(patientDtoFromRequest.getDateOfBirth());
    }
    if (patientDtoFromRequest.getGender() != null) {
      patientFromDb.setGender(patientDtoFromRequest.getGender());
    }
    if (patientDtoFromRequest.getPhone() != null) {
      patientFromDb.setPhone(patientDtoFromRequest.getPhone());
    }
    if (patientDtoFromRequest.getActive() != null) {
      patientFromDb.setActive(patientDtoFromRequest.getActive());
    }
    patientFromDb.setUpdateDate(LocalDateTime.now());
    patientFromDb.setUpdateBy(patientDtoFromRequest.getUpdateBy());

    PatientModel model = new PatientModel()
        .setId(patientFromDb.getId())
        .setDateOfBirth(patientFromDb.getDateOfBirth())
        .setEmail(patientFromDb.getEmail())
        .setFirstName(patientFromDb.getFirstName())
        .setLastName(patientFromDb.getLastName())
        .setGender(patientFromDb.getGender())
        .setPhone(patientFromDb.getPhone())
        .setUpdateDate(patientFromDb.getUpdateDate())
        .setUpdateBy(patientFromDb.getUpdateBy())
        .setZipCode(patientFromDb.getZipCode())
        .setCreateBy(patientFromDb.getCreateBy())
        .setCreateDate(patientFromDb.getCreateDate())
        .setActive(patientFromDb.getActive());
    PatientModel newPatient = patientRepository.save(model);

    return newPatient.getId();
  }

  private PatientDto fromPatientModelToDto(PatientModel model) {
    PatientDto patientDto = new PatientDto()
        .setId(model.getId())
        .setActive(model.getActive())
        .setCreateDate(model.getCreateDate())
        .setCreateBy(model.getCreateBy())
        .setDateOfBirth(model.getDateOfBirth())
        .setEmail(model.getEmail())
        .setFirstName(model.getFirstName())
        .setLastName(model.getLastName())
        .setGender(model.getGender())
        .setPhone(model.getPhone())
        .setUpdateBy(model.getUpdateBy())
        .setUpdateDate(model.getUpdateDate())
        .setZipCode(model.getZipCode());
    return patientDto;
  }

  private PatientModel fromPatientDtoToModel(PatientDto patientDto) {
    PatientModel model = new PatientModel()
        .setActive(patientDto.getActive())
        .setDateOfBirth(patientDto.getDateOfBirth())
        .setEmail(patientDto.getEmail())
        .setFirstName(patientDto.getFirstName())
        .setLastName(patientDto.getLastName())
        .setGender(patientDto.getGender())
        .setPhone(patientDto.getPhone())
        .setZipCode(patientDto.getZipCode())
        .setActive(patientDto.getActive())
        .setCreateBy(patientDto.getId());
    return model;
  }

}
