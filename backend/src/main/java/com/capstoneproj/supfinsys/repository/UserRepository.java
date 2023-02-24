package com.capstoneproj.supfinsys.repository;

import com.capstoneproj.supfinsys.models.Client;
import com.capstoneproj.supfinsys.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
//    Client findByUserName(String userName);

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

}