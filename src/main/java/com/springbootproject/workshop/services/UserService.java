package com.springbootproject.workshop.services;

import com.springbootproject.workshop.entities.User;
import com.springbootproject.workshop.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> object = userRepository.findById(id);
        if (object.isPresent()) {
            return object.get();
        }
        throw new EntityNotFoundException("User not found with id: " + id);
    }

    public User insert(User user) {
       return userRepository.save(user);
    }
}
