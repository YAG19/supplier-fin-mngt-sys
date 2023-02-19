package com.capstoneproj.supfinsys.controller;

import com.capstoneproj.supfinsys.exception.ClientException;
import com.capstoneproj.supfinsys.exception.UsernameAlreadyExistsException;
import com.capstoneproj.supfinsys.exception.UsernameNotFoundException;
import com.capstoneproj.supfinsys.models.Client;
import com.capstoneproj.supfinsys.models.Userdto;
import com.capstoneproj.supfinsys.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/client")
public class ClientRegistrationController {

    @Autowired
    ClientService clientService;
    @PostMapping(path="/registration")
    Client registration(@RequestBody Client client){
        String username = client.getUsername();
        if(clientService.clientUsernameExists(username)) throw new UsernameAlreadyExistsException("Username Already Exists");
        return clientService.createClient(client);
    }
    
    @PostMapping(path="/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Client login(@RequestBody Userdto user){
        if(clientService.clientUsernameExists(user.getUsername())) return clientService.login(user);
        throw new UsernameNotFoundException("Username Dose Not Exist");
    }

}
