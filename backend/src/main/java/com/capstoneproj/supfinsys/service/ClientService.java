package com.capstoneproj.supfinsys.service;

import com.capstoneproj.supfinsys.exception.IncorrectPasswordException;
import com.capstoneproj.supfinsys.models.ClientDto;
import com.capstoneproj.supfinsys.models.User;
import com.capstoneproj.supfinsys.models.Userdto;
import org.springframework.stereotype.Service;

import com.capstoneproj.supfinsys.models.Client;

import java.util.Optional;

@Service("ClientService")
public interface ClientService {
    
    Client createClient(ClientDto client);
    User login(Userdto user);
}
