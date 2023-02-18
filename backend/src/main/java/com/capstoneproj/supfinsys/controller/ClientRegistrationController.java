package com.capstoneproj.supfinsys.controller;

import com.capstoneproj.supfinsys.models.Client;
import com.capstoneproj.supfinsys.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
public class ClientRegistrationController {

    @Autowired
    ClientService clientService;
    @PostMapping(path="/registration")
    ResponseEntity<Boolean> clientRegistration(@RequestBody Client client){
        if(clientService.createClient(client)){
        return ResponseEntity.ok(true);
        };
        return ResponseEntity.ok(false);
    }
}