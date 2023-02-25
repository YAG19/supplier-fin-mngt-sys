package com.capstoneproj.supfinsys.service;

import com.capstoneproj.supfinsys.models.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("UserService")
public interface UserService {

    User getClientByUsername(String userName);
    boolean clientUsernameExists(String username);
}
