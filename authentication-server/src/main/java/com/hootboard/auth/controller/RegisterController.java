package com.hootboard.auth.controller;

import com.hootboard.auth.AUTH_SERVER_API_DICTIONARY;
import com.hootboard.model.RegisterModel;
import com.hootboard.persistence.mysql.entity.Roles;
import com.hootboard.persistence.mysql.entity.User;
import com.hootboard.persistence.mysql.entity.UserRole;
import com.hootboard.persistence.mysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RegisterController {

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = AUTH_SERVER_API_DICTIONARY.REGISTER, method = RequestMethod.POST)
    public ResponseEntity<RegisterModel> register(@RequestBody RegisterModel newUser){

        List<UserRole> defaultRole = new ArrayList<>();
        User user = new User();
        UserRole role = new UserRole();

        try{
            role.setRole(Roles.ADMIN.toString());
            role.setUser(user);
            defaultRole.add(role);
            user.setEnabled(true);
            user.setUserRoles(defaultRole);
            user.setUsername(newUser.getUsername());
            user.setPassword(encoder.encode(newUser.getPassword()));
            userRepository.save(user);
        }catch(Exception ex){
            ex.printStackTrace();
        }

        return new ResponseEntity<RegisterModel>(HttpStatus.OK);

    }
}
