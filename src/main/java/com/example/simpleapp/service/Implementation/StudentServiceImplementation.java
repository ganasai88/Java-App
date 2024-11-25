package com.example.simpleapp.service.Implementation;

import com.example.simpleapp.model.Studentdetails;
import com.example.simpleapp.repository.Studentrepository;
import com.example.simpleapp.service.Studentservice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImplementation implements Studentservice {

    Studentrepository studentrepository;

    public StudentServiceImplementation(Studentrepository studentrepository) {
        this.studentrepository = studentrepository;
    }

    @Override
    public String createstudentdetails(Studentdetails studentdetails) {
        studentrepository.save(studentdetails);
        return "Successfully created student details";
    }

    @Override
    public String updatestudentdetails(Studentdetails studentdetails) {
        studentrepository.save(studentdetails);
        return "Successfully updated student details";
    }

    @Override
    public String deletestudentdetails(String studentid) {
        studentrepository.deleteById(studentid);
        return "Successfully deleted student details";
    }

    @Override
    public Studentdetails getstudentdetails(String studentid) {
        return studentrepository.findById(studentid).get();
    }

    @Override
    public List<Studentdetails> getAllstudentdetails() {
        return studentrepository.findAll();
    }
}
