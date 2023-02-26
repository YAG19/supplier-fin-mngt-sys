package com.capstoneproj.supfinsys.controller;

import com.capstoneproj.supfinsys.exception.UsernameNotFoundException;
import com.capstoneproj.supfinsys.models.User;
import com.capstoneproj.supfinsys.models.UserDto;
import com.capstoneproj.supfinsys.models.UserInfoResponse;
import com.capstoneproj.supfinsys.service.ClientService;
import com.capstoneproj.supfinsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    ClientService clientService;

    @Autowired
    UserService userService;
    @PostMapping(path="/login")
    public ResponseEntity<?> login(@RequestBody UserDto userdto) {
        if(userService.clientUsernameExists(userdto.getUsername())) {
            User user = clientService.login(userdto);
            return ResponseEntity.status(HttpStatus.OK).body(new UserInfoResponse(user.getUserId(),
                    user.getUsername(),
                    user.getRole()));
        }
        throw new UsernameNotFoundException("Username Dose Not Exist");
    }
}
