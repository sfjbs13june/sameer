package com.sameer.hospitalapp.model;

import org.springframework.stereotype.Component;

@Component
public class Prescription {

    String prescriptionId;
    String appointmentId;
    String description;
    String patientName;
    String doctorName;

    public Prescription() {
    }
    public Prescription(String prescriptionId, String appointmentId, String patientName, String doctorName, String description) {
        this.prescriptionId = prescriptionId;
        this.appointmentId = appointmentId;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.description = description;
    }
    public String getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(String prescriptionId) {
        this.prescriptionId = prescriptionId;
    }


    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}


