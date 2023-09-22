package com.sameer.app.repository;

import com.sameer.app.model.Hospital;
import org.springframework.data.repository.CrudRepository;

public interface HospitalRepository extends CrudRepository<Hospital, Integer> {
}