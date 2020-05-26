/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbcore.codecnative.example;

/**
 *
 * @author avbravo
 */
public  class Address {
    private String street;
    private String city;
    private String zip;
private Calle calle;
    public Address() {
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(final String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(final String zip) {
        this.zip = zip;
    }
    
    // Rest of implementation

    public Address(String street, String city, String zip) {
        this.street = street;
        this.city = city;
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Address{" + "street=" + street + ", city=" + city + ", zip=" + zip + ", calle=" + calle + '}';
    }

  

    public Address(String street, String city, String zip, Calle calle) {
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.calle = calle;
    }

    public Calle getCalle() {
        return calle;
    }

    public void setCalle(Calle calle) {
        this.calle = calle;
    }
    
    
    
    
}