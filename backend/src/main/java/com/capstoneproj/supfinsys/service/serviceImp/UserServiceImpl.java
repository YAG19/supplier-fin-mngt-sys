package com.capstoneproj.supfinsys.service.serviceImp;

import com.capstoneproj.supfinsys.models.User;
import com.capstoneproj.supfinsys.repository.UserRepository;
import com.capstoneproj.supfinsys.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Transactional
public class UserServiceImpl implements UserService {


    @Autowired
    UserRepository userRepository;

    @Override
    public Optional<User> getClientByUsername(String userName) {
        return userRepository.findByUsername(userName);
    }

    @Override
    public boolean clientUsernameExists(String username) {
        return userRepository.existsByUsername(username);
    }
}
