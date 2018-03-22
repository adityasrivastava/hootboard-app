package com.hootboard.model;

import org.springframework.format.annotation.NumberFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.List;

public class UserModel {

    private BigInteger id;

    @NotNull(message = "First name is required.")
    private String firstName;

    @NotNull(message = "Last name is required.")

    private String lastName;
    @NumberFormat(pattern = "^[0-9]")

    @NotNull(message = "Phone number is required.")
    private String phoneNumber;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @Valid
    private List<EmailModel> emailAddress;

    @Valid
    private AddressModel addressModel;

    private boolean enabled;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<EmailModel> getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(List<EmailModel> emailAddress) {
        this.emailAddress = emailAddress;
    }

    public AddressModel getAddressModel() {
        return addressModel;
    }

    public void setAddressModel(AddressModel addressModel) {
        this.addressModel = addressModel;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
