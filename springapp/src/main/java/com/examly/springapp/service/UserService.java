package com.examly.springapp.service;

import com.examly.springapp.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);

    List<User> getAllUsers();

    Page<User> getUsers(Pageable pageable);

    Optional<User> getUserById(Long id);

    User updateUser(Long id, User user);

    void deleteUser(Long id);

    List<User> getUsersByRole(String role);
}
