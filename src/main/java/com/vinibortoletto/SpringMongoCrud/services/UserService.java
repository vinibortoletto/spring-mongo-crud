package com.vinibortoletto.SpringMongoCrud.services;

import com.vinibortoletto.SpringMongoCrud.dtos.UserRequestDTO;
import com.vinibortoletto.SpringMongoCrud.exceptions.ConflictException;
import com.vinibortoletto.SpringMongoCrud.exceptions.NotFoundException;
import com.vinibortoletto.SpringMongoCrud.models.User;
import com.vinibortoletto.SpringMongoCrud.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new NotFoundException("User not found"));
    }

    public User save(UserRequestDTO dto) {
        Optional<User> user = userRepository.findByEmail(dto.email());

        if (user.isPresent()) {
            throw new ConflictException("User already exists");
        }

        User newUser = new User();
        BeanUtils.copyProperties(dto, newUser);

        return userRepository.save(newUser);
    }

    public User update(String id, UserRequestDTO dto) {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) {
            throw new NotFoundException("User not found");
        }

        User updatedUser = user.get();
        BeanUtils.copyProperties(dto, updatedUser);

        return userRepository.save(updatedUser);
    }
}
