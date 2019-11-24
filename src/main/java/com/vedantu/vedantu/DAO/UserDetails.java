package com.vedantu.vedantu.DAO;

public class UserDetails {

    private String emailAddress;
    private String phoneNumber;
    private String phoneCode;

    public UserDetails() {
    }

    public UserDetails(String emailAddress, String phoneNumber, String phoneCode) {

        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.phoneCode = phoneCode;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }
}
