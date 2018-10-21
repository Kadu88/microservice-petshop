package com.ceobarros.user.user.controller;

import com.ceobarros.user.user.model.User;
import com.ceobarros.user.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/add-user", method = RequestMethod.POST)
    public void addUser(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("pass") String pass) {
        userService.addUser(name, email, pass);
    }

    @RequestMapping(value = "/user/find-user-by-id", method = RequestMethod.GET)
    public User findUserById(@RequestParam("id-user") Integer idUser) {return userService.getUserById(idUser);}
}
