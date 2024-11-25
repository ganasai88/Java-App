package com.example.simpleapp.service;

import com.example.simpleapp.model.Studentdetails;

import java.util.List;

public interface Studentservice {
    public String createstudentdetails(Studentdetails studentdetails);
    public String updatestudentdetails(Studentdetails studentdetails);
    public String deletestudentdetails(String studentid);
    public Studentdetails getstudentdetails(String studentid);
    public List<Studentdetails> getAllstudentdetails();
}
