package com.hootboard.api.service.user;

import com.hootboard.model.UserModel;
import com.hootboard.model.mapper.UserMapper;
import com.hootboard.persistence.mysql.entity.Roles;
import com.hootboard.persistence.mysql.entity.User;
import com.hootboard.persistence.mysql.entity.UserRole;
import com.hootboard.persistence.mysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Transactional
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void addUser(UserModel userModel, String loginUser) {

        List<UserRole> userRoles = new ArrayList<>();
        User user = UserMapper.userModel_to_user(userModel);

        if(userModel.getPassword() != null)
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));

        // Default Role for User
        UserRole r = new UserRole();
        r.setRole(Roles.USER.toString());
        r.setUser(user);
        userRoles.add(r);

        user.setUserRoles(userRoles);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(BigInteger userId, String loginUser) {
        Optional<User> found = userRepository.findByIdAndCreatedByAndDeleted(userId, loginUser,false);
        
        if(!found.isPresent()){
            throw new NoSuchElementException("Following user does not exist or already removed.");
        }

        User user = found.get();
        user.setDeleted(true);
        user.getAddress().setDeleted(true);

        userRepository.save(user); // Just doing a soft delete!!!
    }

    @Override
    public Page<UserModel> getAllUsers(Pageable pageable, String loginUser) {
        final Page<User> allUsers = userRepository.findByCreatedByAndDeleted(pageable, loginUser,false);

        List<UserModel> userModels = new ArrayList<>();

        for (User allUser : allUsers) {
            UserModel userModel = UserMapper.user_to_userModel(allUser);
            userModels.add(userModel);
        }

        Page<UserModel> allUserModels = new PageImpl<UserModel>(userModels, pageable, allUsers.getTotalPages());

        return allUserModels;
    }

    @Override
    public UserModel getUser(BigInteger userId, String loginUser) throws NoSuchElementException {

        Optional<User> found = userRepository.findByIdAndCreatedByAndDeleted(userId, loginUser,false);

        if(!found.isPresent()){
            throw new NoSuchElementException("User not found.");
        }

        return UserMapper.user_to_userModel(found.get());

    }

    @Override
    public void updateUser(UserModel userModel, String loginUser) {

        Optional<User> found = userRepository.findByIdAndCreatedByAndDeleted(userModel.getId(), loginUser, false);

        if(!found.isPresent()){
            throw new NoSuchElementException("Following user does not exist or already removed.");
        }

        User updateUser = UserMapper.userModel_to_user(userModel);


        userRepository.save(updateUser);
    }
}
