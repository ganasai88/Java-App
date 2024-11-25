package com.example.simpleapp.controller;

import com.example.simpleapp.model.Studentdetails;
import com.example.simpleapp.repository.Studentrepository;
import com.example.simpleapp.service.Studentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Studentapi")
public class StudentController {

    @Autowired
    Studentservice studentservice;

    @GetMapping("welcome")
    public String welcomepage()
        {
        return "Welcome to the Student Details";
    }

    @GetMapping("/{studentid}")
    public Studentdetails getstudentdetails(@PathVariable String studentid){

        return studentservice.getstudentdetails(studentid);
    }

    @GetMapping()
    public List<Studentdetails> getsalltudentdetails(){

        return studentservice.getAllstudentdetails();
    }

    @PostMapping
    public String createstudentdetails(@RequestBody Studentdetails studentdetails){

        return studentservice.createstudentdetails(studentdetails);
    }

    @PutMapping
    public String updatestudentdetails(@RequestBody Studentdetails studentdetails){

        return studentservice.updatestudentdetails(studentdetails);
    }

    @DeleteMapping("/{studentid}")
    public String deletestudentdetails(@PathVariable String studentid){

        return studentservice.deletestudentdetails(studentid);
    }
}
