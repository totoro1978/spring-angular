package com.totoro4.webservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.totoro4.webservice.models.Products;

public interface ProductRepository extends MongoRepository<Products, String> {
	
	@Override
    void delete(Products deleted);
}