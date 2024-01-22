package com.vinibortoletto.SpringMongoCrud.controllers;


import com.vinibortoletto.SpringMongoCrud.dtos.UserRequestDTO;
import com.vinibortoletto.SpringMongoCrud.dtos.UserResponseDTO;
import com.vinibortoletto.SpringMongoCrud.models.User;
import com.vinibortoletto.SpringMongoCrud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<List<UserResponseDTO>> findAll() {
        List<User> userList = userService.findAll();
        List<UserResponseDTO> response = UserResponseDTO.convert(userList);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable String id) {
        User user = userService.findById(id);
        UserResponseDTO response = new UserResponseDTO(user);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping()
    public ResponseEntity<UserResponseDTO> save(@RequestBody UserRequestDTO dto) {
        User user = userService.save(dto);
        UserResponseDTO response = new UserResponseDTO(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserResponseDTO> update(@PathVariable String id, @RequestBody UserRequestDTO dto) {
        User user = userService.update(id, dto);
        UserResponseDTO response = new UserResponseDTO(user);
        return ResponseEntity.ok().body(response);
    }
}
