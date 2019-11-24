package com.vedantu.vedantu.DAO;

public class Address {

    private String lineNumber1;
    private String lineNumber2;
    private String city;
    private String state;
    private String country;
    private String postalCode;

    public Address(String lineNumber1, String lineNumber2, String city, String state, String country, String postalCode) {
        this.lineNumber1 = lineNumber1;
        this.lineNumber2 = lineNumber2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
    }

    public String getLineNumber1() {
        return lineNumber1;
    }

    public void setLineNumber1(String lineNumber1) {
        this.lineNumber1 = lineNumber1;
    }

    public String getLineNumber2() {
        return lineNumber2;
    }

    public void setLineNumber2(String lineNumber2) {
        this.lineNumber2 = lineNumber2;
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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
