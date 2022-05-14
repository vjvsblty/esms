package com.app.esms.service;

import com.app.esms.entity.Patient;
import com.app.esms.entity.Users;
import com.app.esms.repository.PatientRepository;
import com.app.esms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Users> findDonors(Patient patient) {
        List<Users> allDonors = userRepository.findAll();
        return allDonors.stream().filter(user -> user.getBloodGroup().equalsIgnoreCase(patient.getBloodGroup()) &&
                user.getCity().equalsIgnoreCase(patient.getCityWhereAdmitted()) &&
                user.getState().equalsIgnoreCase(patient.getStateWhereAdmitted()) &&
                user.getCountry().equalsIgnoreCase(patient.getCountryWhereAdmitted())).collect(Collectors.toList());
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Users> findDrivers(Patient patient) {
        List<Users> allDrivers = userRepository.findAll();
        return allDrivers.stream().filter(user -> user.getWhoAreYou().contains("Driver") &&
                user.getCity().equalsIgnoreCase(patient.getCityWhereAdmitted()) &&
                user.getState().equalsIgnoreCase(patient.getStateWhereAdmitted()) &&
                user.getCountry().equalsIgnoreCase(patient.getCountryWhereAdmitted())).collect(Collectors.toList());
    }
}
