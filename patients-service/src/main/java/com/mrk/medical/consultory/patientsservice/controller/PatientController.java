package com.mrk.medical.consultory.patientsservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.bohnman.squiggly.Squiggly;
import com.github.bohnman.squiggly.util.SquigglyUtils;
import com.mrk.medical.consultory.patientsservice.dto.PatientDto;
import com.mrk.medical.consultory.patientsservice.service.PatientService;
import io.swagger.annotations.Api;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "patients")
@Api(value = "patients")
public class PatientController {

  private final PatientService patientService;

  @Autowired
  public PatientController(final PatientService patientService) {
    this.patientService = patientService;
  }

  @GetMapping(path="/", produces = MediaType.APPLICATION_JSON_VALUE)
  @CrossOrigin(origins = "http://localhost:3000")
  public ResponseEntity<List<PatientDto>> getPatients(@RequestParam(required = false) Map<String,String> params)
      throws InvocationTargetException, IllegalAccessException {
    List<PatientDto> patients = patientService.findAllPatients(params);
    if (patients.size() > 0 && StringUtils.isNotEmpty(params.get("fields"))){
      ObjectMapper objectMapper = Squiggly.init(new ObjectMapper(), params.get("fields"));
      patients = SquigglyUtils.listify(objectMapper, patients, PatientDto.class);
    }
    return ResponseEntity.ok()
        .body(patients);
  }

  @GetMapping(path="/{patientId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @CrossOrigin(origins = "http://localhost:3000")
  public ResponseEntity<PatientDto> getPatientById(@PathVariable(name = "patientId")long patientId){
    PatientDto patientDto = patientService.findPatientById(patientId);
    if (Optional.ofNullable(patientDto).isPresent()) {
      return ResponseEntity.ok().body(patientDto);
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
  }

  @PostMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
  @CrossOrigin(origins = "http://localhost:3000")
  public void createPatient(@RequestBody PatientDto patientDto, HttpServletResponse response){
    long newPatientId = patientService.createPatient(patientDto);
    response.addHeader("Location: patients/", String.valueOf(newPatientId));
    response.setStatus(HttpServletResponse.SC_CREATED);
  }

  @PutMapping(path="/{patientId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  @CrossOrigin(origins = "http://localhost:3000")
  public void updatePatientById(@RequestBody PatientDto patientDto, @PathVariable(name = "patientId")long patientId, HttpServletResponse response){
    long updatedPatientId = patientService.updatePatient(patientId,patientDto);
    response.addHeader("Location: patients/", String.valueOf(updatedPatientId));
    if (updatedPatientId == patientId) {
      response.setStatus(HttpServletResponse.SC_OK);
    }else{
      response.setStatus(HttpServletResponse.SC_CREATED);
    }

  }

  @DeleteMapping(path="/{patientId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @CrossOrigin(origins = "http://localhost:3000")
  public void deletePatientById(@PathVariable(name = "patientId")long patientId, HttpServletResponse response){
    long updatedPatientId = patientService.updatePatient(patientId,new PatientDto().setActive("N"));
    response.addHeader("Location: patients/", String.valueOf(updatedPatientId));
    if (updatedPatientId == patientId) {
      response.setStatus(HttpServletResponse.SC_OK);
    }
  }
}
