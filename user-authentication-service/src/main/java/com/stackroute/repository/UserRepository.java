package com.stackroute.repository;

import com.stackroute.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    //finding user by emailId and password
    User findByEmailIdAndPassword(String emailId, String password);

    //searching the user by email whether user exists or not
    boolean existsByEmailId(String emailId);
}
