package com.hootboard.api.service.user;

import com.hootboard.model.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;
import java.util.NoSuchElementException;

public interface UserService {

    void addUser(UserModel userModel, String loginUser);

    void deleteUser(BigInteger userId, String loginUser);

    Page<UserModel> getAllUsers(Pageable pageable, String loginUser);

    UserModel getUser(BigInteger userId, String loginUser) throws NoSuchElementException;

    void updateUser(UserModel userModel, String loginUser);
}
