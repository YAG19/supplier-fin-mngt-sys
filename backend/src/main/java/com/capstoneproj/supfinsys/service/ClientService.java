package com.capstoneproj.supfinsys.service;

import org.springframework.stereotype.Service;

import com.capstoneproj.supfinsys.models.Client;

@Service("ClentService")
public interface ClientService {


    Client createClient(Client client);
}
