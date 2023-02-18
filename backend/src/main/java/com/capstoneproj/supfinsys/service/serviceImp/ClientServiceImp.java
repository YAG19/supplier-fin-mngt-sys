package com.capstoneproj.supfinsys.service.serviceImp;

import com.capstoneproj.supfinsys.models.Client;
import com.capstoneproj.supfinsys.models.Userdto;
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
    public Client createClient(Client client) {
        return clientRepository.save(client);

    }

	@Override
	public Client getClient(String userName) {
		return clientRepository.findByUserName(userName);
	}

    @Override
    public Client login(Userdto user) {
        Client dbClient = getClient(user.getUsername());
        if(dbClient.getPassword() == null ) {
            return null;
        }
            if (dbClient.getPassword().equals(user.getPassword())) {
                return dbClient;
            }

        return null;
    }


}
