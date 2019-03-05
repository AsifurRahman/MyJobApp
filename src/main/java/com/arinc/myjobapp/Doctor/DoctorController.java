package com.arinc.myjobapp.Doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/doctorCreate")
    public String doctorCreate() {
        return "addDoctor";
    }

    @PostMapping("/doctorCreate")
    @ResponseBody
    public ResponseEntity<Doctor> doctorCreate(@RequestBody Doctor doctor) {
        System.out.println("Data from view:"+doctor);
        try {
            doctorService.save(doctor);
            return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<Doctor>(doctor, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/doctorList")
    public String userList(Model model) {
        List<Doctor> doctorList=doctorService.getDoctorList();
        model.addAttribute("doctorList",doctorList);
        return "doctorList";
    }

    @GetMapping("/doctorEdit")
    public String doctorEdit(@RequestParam(value = "id",required = true) Integer Id, Model model){
        Doctor doctor=doctorService.findById(Id);
        model.addAttribute("doctor",doctor);
        return "addDoctor";
    }

    @GetMapping("/doctorDelete")
    public String doctorDelete(@RequestParam(value = "id", required = true) Integer Id){
        doctorService.deleteById(Id);
        return "redirect:/doctorList";
    }

}
