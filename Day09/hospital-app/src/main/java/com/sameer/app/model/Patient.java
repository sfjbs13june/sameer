package com.sameer.app.model;

import org.springframework.stereotype.Component;

@Component
public class Patient {


    String name;
    int age;
    String hospitalName;
    String disease;

    public Patient(){}

    public Patient(String name, int id, String hospitalName, String disease) {
        this.name = name;
        this.age = age;
        this.hospitalName = hospitalName;
        this.disease = disease;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public String getDisease() {
        return disease;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }


}
