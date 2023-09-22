package com.sameer.app.repository;

import com.sameer.app.model.Patient;
import org.springframework.data.repository.CrudRepository;


public interface PatientRepository extends CrudRepository<Patient, Integer> {
}
