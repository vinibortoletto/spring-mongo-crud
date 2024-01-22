package com.vinibortoletto.SpringMongoCrud.controllers;


import com.vinibortoletto.SpringMongoCrud.dtos.UserResponseDTO;
import com.vinibortoletto.SpringMongoCrud.models.User;
import com.vinibortoletto.SpringMongoCrud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
