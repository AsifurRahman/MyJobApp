package com.arinc.myjobapp.Doctor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer doctorId;
    private String name;
    private String address;
    private String contact;
    private String city;
    private String license;
    private String email;
    private String awards;
    private String school;
    private String degreeHeld;
    private String expertiseArea;
    private String training;
    private String internship;
    private String researchTopic;
    private String previousCompany;
}
