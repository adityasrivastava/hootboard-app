package com.hootboard.auth.service;

import com.hootboard.persistence.mysql.entity.Roles;
import com.hootboard.persistence.mysql.entity.User;
import com.hootboard.persistence.mysql.entity.UserRole;
import com.hootboard.persistence.mysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service("userDetailsService")
@Transactional
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Optional<User> user = userRepository.findByUsernameAndDeleted(username,false);

        if(!user.isPresent() || !containsAdminRole(user)) {
            throw new UsernameNotFoundException(String.format("The username %s does not exist", username));
        }

        final User loginUser = user.get();

        List<GrantedAuthority> authorities = new ArrayList<>();
        loginUser.getUserRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        });

        UserDetails userDetails = new org.springframework.security.core.userdetails.
                User(loginUser.getUsername(), loginUser.getPassword(), authorities);

        return userDetails;
    }

    private boolean containsAdminRole(Optional<User> user) {
        boolean isAdmin = false;

        if(user.isPresent()){
            for (UserRole role : user.get().getUserRoles()) {
                if (role.getRole().equals(Roles.ADMIN.toString())) {
                    isAdmin = true;
                }
            }
        }

        return isAdmin;
    }


}
