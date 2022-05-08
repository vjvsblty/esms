package com.app.esms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String fullName;
    private String bloodGroup;
    private String cityWhereAdmitted;
    private String stateWhereAdmitted;
    private String countryWhereAdmitted;
    private String phoneToContact;

    public Patient() {
    }

    public Patient(Integer id, String fullName, String bloodGroup, String cityWhereAdmitted, String stateWhereAdmitted, String countryWhereAdmitted, String phoneToContact) {
        this.id = id;
        this.fullName = fullName;
        this.bloodGroup = bloodGroup;
        this.cityWhereAdmitted = cityWhereAdmitted;
        this.stateWhereAdmitted = stateWhereAdmitted;
        this.countryWhereAdmitted = countryWhereAdmitted;
        this.phoneToContact = phoneToContact;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getCityWhereAdmitted() {
        return cityWhereAdmitted;
    }

    public void setCityWhereAdmitted(String cityWhereAdmitted) {
        this.cityWhereAdmitted = cityWhereAdmitted;
    }

    public String getStateWhereAdmitted() {
        return stateWhereAdmitted;
    }

    public void setStateWhereAdmitted(String stateWhereAdmitted) {
        this.stateWhereAdmitted = stateWhereAdmitted;
    }

    public String getCountryWhereAdmitted() {
        return countryWhereAdmitted;
    }

    public void setCountryWhereAdmitted(String countryWhereAdmitted) {
        this.countryWhereAdmitted = countryWhereAdmitted;
    }

    public String getPhoneToContact() {
        return phoneToContact;
    }

    public void setPhoneToContact(String phoneToContact) {
        this.phoneToContact = phoneToContact;
    }
}
