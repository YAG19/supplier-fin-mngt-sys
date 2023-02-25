package com.capstoneproj.supfinsys.service.serviceImp;

import com.capstoneproj.supfinsys.exception.IncorrectPasswordException;
import com.capstoneproj.supfinsys.exception.UsernameNotFoundException;
import com.capstoneproj.supfinsys.models.Client;
import com.capstoneproj.supfinsys.models.ClientDto;
import com.capstoneproj.supfinsys.models.User;
import com.capstoneproj.supfinsys.models.Userdto;
import com.capstoneproj.supfinsys.repository.ClientRepository;
import com.capstoneproj.supfinsys.repository.UserRepository;
import com.capstoneproj.supfinsys.service.ClientService;
import com.capstoneproj.supfinsys.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Transactional
@Service("ClientServiceImp")
public class ClientServiceImp implements ClientService {


    @Autowired
    ClientRepository clientRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;
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
    public User login(Userdto user) {
            User dbUser = userService.getClientByUsername(user.getUsername());
            if (!dbUser.getPassword().equals(user.getPassword())) {
                throw new IncorrectPasswordException("Invalid Password");
            }
            return dbUser;
    }


}
