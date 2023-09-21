package com.sameer.hospitalapp.controller;

import com.sameer.hospitalapp.model.Appointment;
import com.sameer.hospitalapp.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/patient")

public class PatientController {

    @Autowired
    AppointmentRepository appointmentRepository;

    @GetMapping("/myappointment")
    public List<Appointment> getAppointments(@RequestParam String doctorName){

        return null;
    }
    @PostMapping("/save")
    public Appointment saveAppointment(@RequestBody Appointment appointment){

        return appointment;
    }
}