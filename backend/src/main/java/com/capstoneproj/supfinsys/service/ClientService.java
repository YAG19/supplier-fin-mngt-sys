package com.capstoneproj.supfinsys.service;

import com.capstoneproj.supfinsys.models.ClientDto;
import com.capstoneproj.supfinsys.models.User;
import com.capstoneproj.supfinsys.models.UserDto;
import org.springframework.stereotype.Service;

import com.capstoneproj.supfinsys.models.Client;

@Service("ClientService")
public interface ClientService {
    
    Client createClient(ClientDto client);
    User login(UserDto user);
}
