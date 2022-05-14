package com.app.esms.entity;

import javax.persistence.*;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String email;
    private String firstName;
    private String lastName;
    private String mobile;
    private String city;
    private String state;
    private String country;
    private String bloodGroup;
    private String password;
    private String whoAreYou;

    public Users() {
    }

    public Users(Integer id, String email, String firstName, String lastName, String mobile, String city, String state, String country, String bloodGroup, String password, String whoAreYou) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.city = city;
        this.state = state;
        this.country = country;
        this.bloodGroup = bloodGroup;
        this.password = password;
        this.whoAreYou = whoAreYou;
    }

    public Users(String email, String firstName, String lastName, String mobile, String city, String state, String country, String bloodGroup) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.city = city;
        this.state = state;
        this.country = country;
        this.bloodGroup = bloodGroup;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWhoAreYou() {
        return whoAreYou;
    }

    public void setWhoAreYou(String whoAreYou) {
        this.whoAreYou = whoAreYou;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", whoAreYou='" + whoAreYou + '\'' +
                '}';
    }
}
