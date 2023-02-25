package com.capstoneproj.supfinsys.controller;

import com.capstoneproj.supfinsys.exception.ClientException;
import com.capstoneproj.supfinsys.exception.IncorrectPasswordException;
import com.capstoneproj.supfinsys.exception.UsernameAlreadyExistsException;
import com.capstoneproj.supfinsys.exception.UsernameNotFoundException;
import com.capstoneproj.supfinsys.models.*;
import com.capstoneproj.supfinsys.service.ClientService;
import com.capstoneproj.supfinsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
        if(userService.clientUsernameExists(username)) {
            throw new UsernameAlreadyExistsException("Username Already Exists");
        }
         clientService.createClient(clientDto);
         return true;
    }
    
    @PostMapping(path="/login")
    public ResponseEntity<?> login(@RequestBody Userdto userdto) {
        if(userService.clientUsernameExists(userdto.getUsername())) {
            User user = clientService.login(userdto);
            return ResponseEntity.status(HttpStatus.OK).body(new UserInfoResponse(user.getUserId(),
                    user.getUsername(),
                    user.getRole()));
        }
        throw new UsernameNotFoundException("Username Dose Not Exist");
    }

}
