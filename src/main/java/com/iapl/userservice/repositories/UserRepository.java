package com.iapl.userservice.repositories;

import com.iapl.userservice.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
