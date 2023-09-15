package com.sameer.app.controller;

import com.sameer.app.model.Hospital;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HospitalController {

    Map<String, Hospital> hospitalMap= new HashMap<String, Hospital>();

    @PostMapping("/create")
    public Hospital createHospital(@RequestBody Hospital hospitalName){
        hospitalMap.put(hospitalName.getHospitalName(),hospitalName);
        return hospitalName;
    }

    @GetMapping("/read")
    public Hospital readHospital(@RequestParam("hospitalName") String hospitalName){
        return hospitalMap.get(hospitalName);
    }

    @PutMapping("/update")
    public Hospital updateHospital(@RequestParam("hospitalName") String hospitalName, @RequestParam("Id") int id){
        Hospital hospital= hospitalMap.get(hospitalName);
        hospital.setId(id);
        hospitalMap.put(hospitalName,hospital);
        return hospital;
    }

    @DeleteMapping("/delete")
    public void deleteHospital(@RequestParam("hospitalName") String hospitalName){
        hospitalMap.remove(hospitalName);
    }

    @GetMapping("/read/{name}")
    public Hospital readHospitalName(@PathVariable String hospitalName){
        return hospitalMap.get(hospitalName);
    }

}




