package com.sameer.hospitalapp.repository;

import com.sameer.hospitalapp.model.Prescription;

import java.util.HashMap;
import java.util.Map;


public class PrescriptionRepository {

    private static Map<String, Prescription> prescriptionMap = new HashMap<String, Prescription>();

    public static Prescription getAllPrescriptions(String doctorName){
        return prescriptionMap.get(doctorName);
    }

    }

    public  void savePrescription(String name){
        prescriptionMap.put(name,prescription);
    }
}