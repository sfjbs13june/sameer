package com.sameer.app.model;

import org.springframework.stereotype.Component;

@Component
public class Hospital{
    int id;
    String hospitalName;
    String address;

    public Hospital(){}

    public Hospital( int id, String hospitalName, String address) {
        this.id = id;
        this.hospitalName = hospitalName;
        this.address = address;
    }
    public int getId() {
        return id;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public String getAddress() {
        return address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}


