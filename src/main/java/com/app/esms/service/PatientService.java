package com.app.esms.service;

import com.app.esms.entity.Patient;
import com.app.esms.entity.Users;

import java.util.List;

public interface PatientService {
    List<Users> findDonors(Patient patient);
}
