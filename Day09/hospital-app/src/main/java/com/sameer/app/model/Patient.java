package com.sameer.app.model;

import org.springframework.stereotype.Component;

@Component
public class Patient {


    String name;
    int id;
    String hospitalName;
    String disease;

    public Patient(){}

    public Patient(String name, int id, String hospitalname, String disease) {
        this.name = name;
        this.id = id;
        this.hospitalname = hospitalname;
        this.disease = disease;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getHospitalname() {
        return hospitalname;
    }

    public String getDisease() {
        return disease;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }


}
