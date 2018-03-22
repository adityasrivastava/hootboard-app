package com.hootboard.api.controller;

import ch.qos.logback.classic.Logger;
import com.hootboard.api.API_URL_DICTIONARY;
import com.hootboard.api.exception.RestException;
import com.hootboard.api.service.user.UserService;
import com.hootboard.common.logger.Log;
import com.hootboard.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;
import java.security.Principal;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = API_URL_DICTIONARY.BASE_URL)
public class UserController {

    @Log
    Logger LOG;

    @Autowired
    UserService userService;

    @RequestMapping(value = API_URL_DICTIONARY.USERS, method = RequestMethod.GET)
    public ResponseEntity<Page<UserModel>> users(@RequestParam(value = "page") int page,
                                                 @RequestParam(value = "size") int size, final Principal principal) throws RestException {
        Pageable pageable;
        Page<UserModel> allUsers;
        try{
            pageable = PageRequest.of(page,size);
            allUsers = userService.getAllUsers(pageable, principal.getName());
        }catch(Exception ex){
            LOG.error("Users get all failed with an exception. ", ex);
            throw new RestException(ex.getMessage());
        }
        return new ResponseEntity<Page<UserModel>>(allUsers,HttpStatus.OK);
    }

    @RequestMapping(value = API_URL_DICTIONARY.USER, method = RequestMethod.GET)
    public ResponseEntity<UserModel> user(@PathVariable(value = "userId") BigInteger userId, final Principal principal) throws RestException {

        UserModel userModel;
        try{
            userModel = userService.getUser(userId, principal.getName());
        }catch(NoSuchElementException ex){
            LOG.error("User {} not found exception", userId);
            throw new RestException(ex.getMessage());
        }catch(Exception ex){
            LOG.error("User {} get request failed. Error : ", userId, ex);
            throw new RestException(ex.getMessage());
        }

        return new ResponseEntity<UserModel>(userModel,HttpStatus.OK);
    }

    @RequestMapping(value = API_URL_DICTIONARY.USERS, method = RequestMethod.POST)
    public ResponseEntity<UserModel> addUser(@Valid @RequestBody(required = true) UserModel addUser, final Principal principal) throws RestException {

        try{
            userService.addUser(addUser, principal.getName());
        }catch (Exception ex){
            LOG.error("Add new user failed with an exception.", ex);
            throw new RestException(ex.getMessage());
        }
        return new ResponseEntity<UserModel>(HttpStatus.OK);
    }

    @RequestMapping(value = API_URL_DICTIONARY.USER, method = RequestMethod.PUT)
    public ResponseEntity<UserModel> updateUser(@Valid @RequestBody(required = true)UserModel updateUser, final Principal principal) throws RestException {
        try{
            userService.updateUser(updateUser, principal.getName());
        }catch (Exception ex){
            LOG.error("Update user failed with an exception.", ex);
            throw new RestException(ex.getMessage());
        }
        return new ResponseEntity<UserModel>(HttpStatus.OK);
    }

    @RequestMapping(value = API_URL_DICTIONARY.USER, method = RequestMethod.DELETE)
    public ResponseEntity<UserModel> deleteUser(@PathVariable(value = "userId") BigInteger userId, final Principal principal) throws RestException {
        try{
            userService.deleteUser(userId, principal.getName());
        }catch (Exception ex){
            LOG.error("Delete user failed with an exception.", ex);
            throw new RestException(ex.getMessage());
        }
        return new ResponseEntity<UserModel>(HttpStatus.OK);
    }
}
