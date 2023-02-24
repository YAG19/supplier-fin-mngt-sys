package com.capstoneproj.supfinsys.service.serviceImp;

import com.capstoneproj.supfinsys.models.Client;
import com.capstoneproj.supfinsys.models.ClientDto;
import com.capstoneproj.supfinsys.models.User;
import com.capstoneproj.supfinsys.models.Userdto;
import com.capstoneproj.supfinsys.repository.ClientRepository;
import com.capstoneproj.supfinsys.repository.UserRepository;
import com.capstoneproj.supfinsys.service.ClientService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class ClientServiceImp implements ClientService {


    @Autowired
    ClientRepository clientRepository;

    @Autowired
    UserRepository userRepository;
    @Override
    public Client createClient(ClientDto clientDto) {

        User user = User.builder()
                .role("CLIENT")
                .username(clientDto.getUsername())
                .password(clientDto.getPassword())
                .build();

        Client client = Client.builder()
                .address(clientDto.getAddress())
                .email(clientDto.getEmail())
                .name(clientDto.getName())
                .loanAccNumber(clientDto.getLoanAccNumber())
                .loanInfo(clientDto.getLoanInfo())
                .mobileNumber(clientDto.getMobileNumber())
                .user(user)
                .build();

        user.setClient(client);
        userRepository.save(user);
        return client;
    }

    @Override
    public Client login(Userdto user) {
//        Client dbClient = getClientByUsername(user.getUsername());
//        if(dbClient.getPassword() == null ) {
//            return null;
//        }
//            if (dbClient.getPassword().equals(user.getPassword())) {
//                return dbClient;
//            }
        return null;
    }


}
