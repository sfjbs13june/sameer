package com.rama.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @GetMapping("/name")
    public string name(){
    return Sameer;}

    @GetMapping("/age")
    public int age(){
    return 28;}

    @GetMapping("/address")
    public string address(){
    return Pune;}

}
