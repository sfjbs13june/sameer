package com.sameer.hospitalapp.repository;
import com.sameer.hospitalapp.model.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

public class AppointmentRepository {

    private Map<String, Appointment> appointmapMap= new HashMap<String,Appointment>();

    public Appointment getAppointments(String doctorName){
        return appointmapMap.get(doctorName);
    }

    public void saveAppointment(String name,Appointment appointment){
        appointmapMap.put(name,appointment);
    }

}





