package com.sameer.app.controller;

import com.sameer.app.model.Patient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

public class PatientController {

    Map<String, Patient> patientMap= new HashMap<String, Patient>();

    @PostMapping("/create")
    public Patient createPatient(@RequestBody Patient patient){
        patientMap.put(patient.getName(),patient);
        return patient;
    }

    @GetMapping("/read")
    public Patient readPatient(@RequestParam("name") String name){
        return patientMap.get(name);
    }

    @PutMapping("/update")
    public Patient updatePatient(@RequestParam("name") String name, @RequestParam("age") int age){
        Patient patient= patientMap.get(name);
        patient.setAge(age);
        patientMap.put(name,patient);
        return patient;
    }

    @DeleteMapping("/delete")
    public void deletePatient(@RequestParam("name") String name){
        patientMap.remove(name);
    }

    @GetMapping("/read/{name}")
    public Patient ReadNamePatient(@PathVariable String name){
        return patientMap.get(name);
    }

}


