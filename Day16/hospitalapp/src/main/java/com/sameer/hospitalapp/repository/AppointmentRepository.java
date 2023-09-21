package com.sameer.hospitalapp.repository;
import com.sameer.hospitalapp.model.Appointment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
@Repository
public class AppointmentRepository {

    private Map<String, Appointment> appointmentMap= new HashMap<String,Appointment>();

    public Appointment getAppointments(String doctorName){
        return appointmentMap.get(doctorName);
    }

    public Appointment getMyAppointments(String patientName){
        return appointmentMap.get(patientName);
    }



    public void saveAppointment(String name,Appointment appointment){
        appointmentMap.put(name,appointment);
    }



}


