package com.example.simpleapp.repository;

import com.example.simpleapp.model.Studentdetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Studentrepository extends JpaRepository<Studentdetails, String> {

}
