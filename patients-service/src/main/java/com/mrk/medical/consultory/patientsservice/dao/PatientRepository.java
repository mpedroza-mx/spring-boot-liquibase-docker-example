package com.mrk.medical.consultory.patientsservice.dao;

import com.mrk.medical.consultory.patientsservice.model.PatientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<PatientModel,Long>,
    JpaSpecificationExecutor<PatientModel> {

}
