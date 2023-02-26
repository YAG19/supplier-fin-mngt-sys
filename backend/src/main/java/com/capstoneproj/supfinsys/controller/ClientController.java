package com.capstoneproj.supfinsys.controller;

import com.capstoneproj.supfinsys.exception.ResponseMessage;
import com.capstoneproj.supfinsys.exception.UsernameAlreadyExistsException;
import com.capstoneproj.supfinsys.exception.UsernameNotFoundException;
import com.capstoneproj.supfinsys.models.*;
import com.capstoneproj.supfinsys.service.ClientService;
import com.capstoneproj.supfinsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @Autowired
    UserService userService;
    @PostMapping(path="/registration")
    ResponseEntity<ResponseMessage> registration(@RequestBody ClientDto clientDto){
        String username = clientDto.getUsername();
        if(userService.clientUsernameExists(username)) {
            throw new UsernameAlreadyExistsException("Username Already Exists");
        }
         clientService.createClient(clientDto);
         return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Successfully Registered"));
    }


}
