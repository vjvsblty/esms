package com.app.esms.controller;

import com.app.esms.entity.Login;
import com.app.esms.entity.Patient;
import com.app.esms.entity.Users;
import com.app.esms.service.EmailService;
import com.app.esms.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class ServiceController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private EmailService emailService;

    private static List<Users> fetchedDonors;

    private static List<Users> fetchedDrivers;

    private static Patient patientNeededBlood;

    private static Patient patientNeedAmbulance;


    @GetMapping("/blood-enquiry")
    public String bloodEnquiry(Model model){
        model.addAttribute("patient", new Patient());
        Users user = UserController.userLoggedIn;
        if(user != null)
            model.addAttribute("name", user.getFirstName()+" "+user.getLastName());

        return "donor_enquiry";
    }

    @GetMapping("/ambulance-enquiry")
    public String ambulanceEnquiry(Model model){
        model.addAttribute("patient", new Patient());
        Users user = UserController.userLoggedIn;
        if(user != null)
            model.addAttribute("name", user.getFirstName()+" "+user.getLastName());

        return "ambulance_enquiry";
    }

    @PostMapping("/fetch-donors")
    public ModelAndView getDonors(@ModelAttribute("patient") Patient patient,
                            BindingResult result, ModelAndView model){
        model.addObject("patient", patient);
        patientService.savePatient(patient);
        List<Users> donors = patientService.findDonors(patient);
        model.addObject("donors", donors);
        fetchedDonors = donors;
        patientNeededBlood = patient;
        Users user = UserController.userLoggedIn;
        if(user != null)
            model.addObject("name", user.getFirstName()+" "+user.getLastName());
        else{
            ModelAndView modelAndView = new ModelAndView("redirect:/login");
            return modelAndView;
        }
        model.setViewName("donors_list");
        return model;
    }


    @PostMapping("/fetch-drivers")
    public ModelAndView getDrivers(@ModelAttribute("patient") Patient patient,
                                  BindingResult result, ModelAndView model){
        model.addObject("patient", patient);
        patientService.savePatient(patient);
        List<Users> drivers = patientService.findDrivers(patient);
        model.addObject("drivers", drivers);
        fetchedDrivers = drivers;
        patientNeedAmbulance = patient;
        Users user = UserController.userLoggedIn;
        if(user != null)
            model.addObject("name", user.getFirstName()+" "+user.getLastName());
        else{
            ModelAndView modelAndView = new ModelAndView("redirect:/login");
            return modelAndView;
        }
        model.setViewName("drivers_list");
        return model;
    }

    @RequestMapping("/alert-blood-donors")
    public ModelAndView alertBloodDonors(Model model) throws IOException {
        System.out.println("in alert blood donors");
        ModelAndView modelAndView = new ModelAndView("operation_page");
        Users user = UserController.userLoggedIn;
        modelAndView.addObject("name", user.getFirstName()+" "+user.getLastName());
        modelAndView.addObject("alert_msg","Alert has been sent to donors, wait for response now!!");
        emailService.sendAlertToDonors(patientNeededBlood, fetchedDonors);
        return modelAndView;
    }

    @RequestMapping("/alert-ambulance-donors")
    public ModelAndView alertAmbulanceDrivers(Model model) throws IOException {
        System.out.println("in alert ambulance drivers");
        ModelAndView modelAndView = new ModelAndView("operation_page");
        Users user = UserController.userLoggedIn;
        modelAndView.addObject("name", user.getFirstName()+" "+user.getLastName());
        modelAndView.addObject("alert_msg","Alert has been sent to drivers, wait for response now!!");
        emailService.sendAlertToDrivers(patientNeedAmbulance, fetchedDrivers);
        return modelAndView;
    }
}
