package com.totoro4.webservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.totoro4.webservice.models.Role;

public interface RoleRepository extends MongoRepository<Role, String> {

	Role findByRole(String role);
}
