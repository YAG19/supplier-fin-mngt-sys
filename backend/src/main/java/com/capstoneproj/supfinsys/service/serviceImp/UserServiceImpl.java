package com.capstoneproj.supfinsys.service.serviceImp;

import com.capstoneproj.supfinsys.exception.UsernameNotFoundException;
import com.capstoneproj.supfinsys.models.User;
import com.capstoneproj.supfinsys.repository.UserRepository;
import com.capstoneproj.supfinsys.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Transactional
@Service("UserServiceImp")
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User getClientByUsername(String userName) throws UsernameNotFoundException {
        return userRepository.findByUsername(userName).orElseThrow( () ->
                new UsernameNotFoundException("Username Does Not Exists"));
    }

    @Override
    public boolean clientUsernameExists(String username) {
        return userRepository.existsByUsername(username);
    }
}
