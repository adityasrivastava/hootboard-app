package com.hootboard.persistence.mysql.repository;

import com.hootboard.persistence.mysql.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, BigInteger>{
    Page<User> findByCreatedByAndDeleted(Pageable pageable,String createdBy, boolean deleted);
    Optional<User> findByIdAndCreatedByAndDeleted(BigInteger userId, String createdBy, boolean deleted);
    Optional<User> findByUsernameAndDeleted(String username, boolean deleted);
    Optional<User> findByIdAndDeleted(BigInteger id, boolean deleted);
}
