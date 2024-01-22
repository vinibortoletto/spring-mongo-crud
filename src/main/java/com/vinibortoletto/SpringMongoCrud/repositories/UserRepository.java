package com.vinibortoletto.SpringMongoCrud.repositories;

import com.vinibortoletto.SpringMongoCrud.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
}
