package com.example.simpleapp.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="Student_Info")
public class Studentdetails {
    @Id
    private String studentid;
    private String studentname;

    public Studentdetails( String studentid,String studentname) {
        this.studentid = studentid;
        this.studentname = studentname;
    }

    public Studentdetails() {
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }
}

