package com.vinibortoletto.SpringMongoCrud.services;

import com.vinibortoletto.SpringMongoCrud.models.User;
import com.vinibortoletto.SpringMongoCrud.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
