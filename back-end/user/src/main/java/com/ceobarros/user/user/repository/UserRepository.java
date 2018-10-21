package com.ceobarros.user.user.repository;

import com.ceobarros.user.user.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
