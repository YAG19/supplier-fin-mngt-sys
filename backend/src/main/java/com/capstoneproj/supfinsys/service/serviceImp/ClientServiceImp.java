package com.capstoneproj.supfinsys.service.serviceImp;

import com.capstoneproj.supfinsys.models.Client;
import com.capstoneproj.supfinsys.repository.ClientRepository;
import com.capstoneproj.supfinsys.service.ClientService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ClientServiceImp implements ClientService {


    @Autowired
    ClientRepository clientRepository;

    @Override
    public Boolean createClient(Client client) {
        clientRepository.save(client);
        return true;
    }
}
