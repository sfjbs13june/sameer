package com.sameer.hospitalapp.controller;

import com.sameer.hospitalapp.model.Prescription;
import com.sameer.hospitalapp.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/prescription")
public class PrescriptionController {

    @Autowired
    PrescriptionRepository prescriptionRepository;

    @GetMapping("/viewprescription")
    public static Prescription getAllPrescriptions(@RequestParam String name){

        return PrescriptionRepository.getAllPrescriptions(name);
    }

    @PostMapping("/saveprescription")
        public static Prescription savePrescription(@RequestBody Prescription prescription){
            String name = prescription.getDescription();
            PrescriptionRepository.savePrescription(name);
        return prescription;
    }

    }