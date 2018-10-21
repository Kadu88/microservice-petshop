package com.ceobarros.user.user.controller;

import com.ceobarros.user.user.model.User;
import com.ceobarros.user.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public void addUser(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("pass") String pass) {
        userService.addUser(name, email, pass);
    }

    @RequestMapping(value = "/find-user-by-id", method = RequestMethod.GET)
    public User findUserById(@RequestParam("id-user") Integer idUser) {return userService.getUserById(idUser);}
}
