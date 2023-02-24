package com.capstoneproj.supfinsys.controller;

import com.capstoneproj.supfinsys.exception.ClientException;
import com.capstoneproj.supfinsys.exception.UsernameAlreadyExistsException;
import com.capstoneproj.supfinsys.exception.UsernameNotFoundException;
import com.capstoneproj.supfinsys.models.Client;
import com.capstoneproj.supfinsys.models.ClientDto;
import com.capstoneproj.supfinsys.models.Userdto;
import com.capstoneproj.supfinsys.service.ClientService;
import com.capstoneproj.supfinsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/client")
public class ClientRegistrationController {

    @Autowired
    ClientService clientService;

    @Autowired
    UserService userService;
    @PostMapping(path="/registration")
    boolean registration(@RequestBody ClientDto clientDto){
        String username = clientDto.getUsername();
        if(userService.clientUsernameExists(username)) throw new UsernameAlreadyExistsException("Username Already Exists");
         clientService.createClient(clientDto);
         return true;
    }
    
    @PostMapping(path="/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Client login(@RequestBody Userdto user){
        if(userService.clientUsernameExists(user.getUsername())) return clientService.login(user);
        throw new UsernameNotFoundException("Username Dose Not Exist");
    }

}
