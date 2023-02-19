package com.capstoneproj.supfinsys.service;

import com.capstoneproj.supfinsys.models.Userdto;
import org.springframework.stereotype.Service;

import com.capstoneproj.supfinsys.models.Client;

@Service("ClientService")
public interface ClientService {
    
    Client createClient(Client client);
    Client getClientByUsername(String userName);
    boolean clientUsernameExists(String username);
    Client login(Userdto user);
}
