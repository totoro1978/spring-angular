package com.totoro4.webservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.totoro4.webservice.models.User;

public interface UserRepository extends MongoRepository<User, String> {

	User findByEmail(String email);
}