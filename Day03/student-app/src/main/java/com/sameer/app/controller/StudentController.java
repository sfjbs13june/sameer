package com.sameer.app.controller;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/getstudent")
    public String getStudent(){
        return "student1";
    }

    @PutMapping("/updatestudent")
    public String updateStudent(){
        return "Successfully updated";
    }

    @DeleteMapping("/deletestudent")
    public String deleteStudent(){
        return "Successfully deleted student";
    }
}