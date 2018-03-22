package com.hootboard.model;

import javax.validation.constraints.Email;
import java.math.BigInteger;

public class EmailModel {

    private BigInteger id;

    @Email(message = "Provide valid email address.")
    private String emailAddress;

    private int status;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
