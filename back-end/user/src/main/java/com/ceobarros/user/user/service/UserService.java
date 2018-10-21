package com.ceobarros.user.user.service;

import com.ceobarros.user.user.model.User;
import com.ceobarros.user.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public void addUser(String name, String email, String pass) {
        User user = new User(name, email, pass);
        user.setCreationDate(LocalDateTime.now());
        userRepository.save(user);
    }

    public User getUserById(Integer idUser) {
        Optional<User> optionalUser = userRepository.findById(idUser);
        return optionalUser.ofNullable(optionalUser.get()).get();
    }
}
