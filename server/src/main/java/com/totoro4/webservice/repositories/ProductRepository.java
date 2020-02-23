package com.totoro4.webservice.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.totoro4.webservice.models.Products;

public interface ProductRepository extends MongoRepository<Products, String> {
	
	@Override
    void delete(Products deleted);

	@Query("{ 'userId' : ?0 }")
	List<Products> findAll(String userId);
}