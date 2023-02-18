package com.capstoneproj.supfinsys.service;

import org.springframework.stereotype.Service;

import com.capstoneproj.supfinsys.models.Client;
import org.springframework.stereotype.Service;

@Service("ClientService")
@Service("ClentService")
public interface ClientService {
    
    Boolean createClient(Client client);
}
