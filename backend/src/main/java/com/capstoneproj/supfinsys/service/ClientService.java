package com.capstoneproj.supfinsys.service;

import com.capstoneproj.supfinsys.models.Client;
import org.springframework.stereotype.Service;

@Service("ClientService")
public interface ClientService {
    
    Boolean createClient(Client client);
}
