package com.capstoneproj.supfinsys.service;

import org.springframework.stereotype.Service;

import com.capstoneproj.supfinsys.models.Client;
import org.springframework.stereotype.Service;

@Service("ClientService")
public interface ClientService {
    
    Client createClient(Client client);
    Client getClient(String userName);
}
