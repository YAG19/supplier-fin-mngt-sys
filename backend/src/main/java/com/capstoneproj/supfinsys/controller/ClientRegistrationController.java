package com.capstoneproj.supfinsys.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
public class ClientRegistrationController {

    @PostMapping("/registration")
    Boolean clientRegistration(){
        return true;
    }
}
