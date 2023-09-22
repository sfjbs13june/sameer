package com.sameer.hospitalapp.controller;

import com.sameer.hospitalapp.model.Appointment;
import com.sameer.hospitalapp.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value ="/doctor")

public class DoctorController {


    @Autowired
        AppointmentRepository appointmentRepository;

        @GetMapping("/doctorappointment")
        public List<Appointment> getAppointments(@RequestParam String doctorName){

            return null;
        }
        @PostMapping("/save")
        public Appointment saveAppointment(@RequestBody Appointment appointment){

            return appointment;
        }
    }