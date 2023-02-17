package controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("client")
public class ClientRegistrationController {

    @PostMapping("/registration")
    Boolean clientRegistration(){
        return true;
    }
}
