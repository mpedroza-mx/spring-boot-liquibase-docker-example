package com.mrk.medical.consultory.patientsservice.service;

import com.mrk.medical.consultory.patientsservice.dto.PatientDto;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public interface PatientService {

  List<PatientDto> findAllPatients(Map<String, String> fields)
      throws InvocationTargetException, IllegalAccessException;

  PatientDto findPatientById(long patientId);

  long createPatient(PatientDto patientDto);

  long updatePatient(long patientId, PatientDto patientDto);
}
