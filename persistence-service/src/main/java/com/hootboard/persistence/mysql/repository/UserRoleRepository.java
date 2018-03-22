package com.hootboard.persistence.mysql.repository;

import com.hootboard.persistence.mysql.entity.User;
import com.hootboard.persistence.mysql.entity.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, String>{

    User findByUserId(String userId);
}
