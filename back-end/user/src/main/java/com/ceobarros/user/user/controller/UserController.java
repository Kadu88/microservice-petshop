package com.ceobarros.user.user.controller;

import com.ceobarros.user.user.model.User;
import com.ceobarros.user.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>
    webServerFactoryCustomizer() {
        return factory -> factory.setContextPath("/user");
    }

    @RequestMapping(value = "add-user", method = RequestMethod.POST)
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @RequestMapping(value = "/find-user-by-id", method = RequestMethod.GET)
    public User findUserById(@RequestParam("id-user") Integer idUser) {return userService.getUserById(idUser);}
}
