package com.arinc.myjobapp.Doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor save(Doctor doctor){
        return doctorRepository.save(doctor);
    }

    public List<Doctor> getDoctorList() {
        return doctorRepository.findAll();
    }

    public Doctor findById(Integer Id){
        return doctorRepository.findOne(Id);
    }

    public void deleteById(Integer Id){
        doctorRepository.delete(Id);
    }
}
