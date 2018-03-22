package com.hootboard.model.mapper;

import com.hootboard.model.AddressModel;
import com.hootboard.model.EmailModel;
import com.hootboard.model.UserModel;
import com.hootboard.persistence.mysql.entity.Address;
import com.hootboard.persistence.mysql.entity.Email;
import com.hootboard.persistence.mysql.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static User userModel_to_user(UserModel userModel){

        User user = new User();
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setEnabled(userModel.isEnabled());
        user.setPhoneNumber(userModel.getPhoneNumber());
        user.setUsername(userModel.getUsername());
        user.setAddress(addressModel_to_address(userModel.getAddressModel()));
        List<Email> emails = new ArrayList<>();

        for (EmailModel emailModel : userModel.getEmailAddress()) {
            emails.add(emailModel_to_email(emailModel));
        }

        user.setEmails(emails);

        return user;
    }

    public static Address addressModel_to_address(AddressModel addressModel) {
        Address address = new Address();
        address.setId(address.getId());
        address.setStreetAddress1(addressModel.getStreetAddress1());
        address.setStreetAddress2(addressModel.getStreetAddress2());
        address.setCity(addressModel.getCity());
        address.setCountry(addressModel.getCountry());
        address.setPostalCode(addressModel.getPostalCode());
        address.setState(addressModel.getState());
        return address;
    }

    public static Email emailModel_to_email(EmailModel emailModel){
        Email email = new Email();
        email.setId(email.getId());
        email.setEmailAddress(emailModel.getEmailAddress());
        email.setStatus(emailModel.getStatus());
        return email;
    }

    public static UserModel user_to_userModel(User user, List<Email> emails, Address address){
        UserModel userModel = new UserModel();
        userModel.setId(user.getId());
        if(address!=null)
            userModel.setAddressModel(address_to_addressModel(address));
        userModel.setFirstName(user.getFirstName());
        userModel.setLastName(user.getLastName());
        userModel.setUsername(user.getUsername());
        userModel.setId(user.getId());
        userModel.setPhoneNumber(user.getPhoneNumber());

        List<EmailModel> emailModels = new ArrayList<>();

        if(emails!=null)
            for (Email email : emails) {
                email_to_emailModel(email);
            }

        return userModel;
    }

    public static AddressModel address_to_addressModel(Address address) {
        AddressModel addressModel = new AddressModel();
        addressModel.setId(address.getId());
        addressModel.setCity(address.getCity());
        addressModel.setCountry(address.getCountry());
        addressModel.setPostalCode(address.getPostalCode());
        addressModel.setState(address.getState());
        addressModel.setStreetAddress1(address.getStreetAddress1());
        addressModel.setStreetAddress2(address.getStreetAddress2());
        return addressModel;
    }

    public static EmailModel email_to_emailModel(Email email){
        EmailModel emailModel = new EmailModel();
        emailModel.setId(email.getId());
        emailModel.setEmailAddress(email.getEmailAddress());
        emailModel.setStatus(email.getStatus());
        return emailModel;
    }

}
