package com.vinibortoletto.SpringMongoCrud.dtos;


import com.vinibortoletto.SpringMongoCrud.models.User;

import java.util.List;

public record UserResponseDTO(
    String id,
    String name,
    String email
) {

    public UserResponseDTO(User user) {
        this(
            user.getId(),
            user.getName(),
            user.getEmail()
        );
    }

    public static List<UserResponseDTO> convert(List<User> userList) {
        return userList.stream().map(UserResponseDTO::new).toList();
    }
}