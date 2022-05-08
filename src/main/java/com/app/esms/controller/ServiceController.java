package com.app.esms.controller;

import com.app.esms.entity.Login;
import com.app.esms.entity.Patient;
import com.app.esms.entity.Users;
import com.app.esms.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ServiceController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/blood-enquiry")
    public String bloodEnquiry(Model model){
        model.addAttribute("patient", new Patient());
        return "donor_enquiry";
    }

    @GetMapping("/ambulance-enquiry")
    public String ambulanceEnquiry(Model model){
        model.addAttribute("patient", new Patient());
        return "ambulance-enquiry";
    }

    @PostMapping("/fetch-donors")
    public ModelAndView getDonors(@ModelAttribute("patient") Patient patient,
                            BindingResult result, ModelAndView model){
        model.addObject("patient", patient);
        List<Users> donors = patientService.findDonors(patient);
        model.addObject("donors", donors);
        model.setViewName("donors_list");
        return model;
    }
}
