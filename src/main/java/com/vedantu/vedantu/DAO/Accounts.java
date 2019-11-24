package com.vedantu.vedantu.DAO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Accounts {

    @Id
    private String accountId;

    private String userProfileId;

    private Address address;

    private List<Address> billingAddress;

    private String taxationNumber;

    private AccountConfig accountConfig;

    private UserDetails userDetails;

    private CountryCode countryCode;

    public Accounts() {
    }

    public Accounts(String userProfileId, Address address, List<Address> billingAddress, String taxationNumber, AccountConfig accountConfig, UserDetails userDetails, CountryCode countryCode) {
        this.userProfileId = userProfileId;
        this.address = address;
        this.billingAddress = billingAddress;
        this.taxationNumber = taxationNumber;
        this.accountConfig = accountConfig;
        this.userDetails = userDetails;
        this.countryCode = countryCode;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(String userProfileId) {
        this.userProfileId = userProfileId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Address> getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(List<Address> billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getTaxationNumber() {
        return taxationNumber;
    }

    public void setTaxationNumber(String taxationNumber) {
        this.taxationNumber = taxationNumber;
    }

    public AccountConfig getAccountConfig() {
        return accountConfig;
    }

    public void setAccountConfig(AccountConfig accountConfig) {
        this.accountConfig = accountConfig;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public CountryCode getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(CountryCode countryCode) {
        this.countryCode = countryCode;
    }
}
