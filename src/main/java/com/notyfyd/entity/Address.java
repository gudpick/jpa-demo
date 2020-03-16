package com.notyfyd.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String building;
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipcode;
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getBuilding() {
        return this.building;
    }
    public void setBuilding(String building) {
        this.building = building;
    }
    public String getStreet() {
        return this.street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getCity() {
        return this.city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return this.state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getCountry() {
        return this.country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getZipcode() {
        return this.zipcode;
    }
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}