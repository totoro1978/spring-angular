package com.totoro4.webservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.totoro4.webservice.models.Products;
import com.totoro4.webservice.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public void addProduct(Products product) {
		productRepository.save(product);
	}

	public Iterable<Products> getProducts(String userId) {
		
//		WebClient webClient = WebClient.builder().baseUrl("http://localhost:8000")
//			.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
////			.filter(logRequest())
//			.build();
//
//		String stockResponse = webClient.get().uri("/companies?list={companies}", "{\"items\" : [\"AMZN\", \"FNCL\"]}").retrieve().bodyToMono(String.class).block();
//		System.out.println("Response: " + stockResponse);
//		
//		Gson gson = new Gson();
//		ResponseStock resStock = gson.fromJson(stockResponse, ResponseStock.class);
//		System.out.println(resStock.toString());
		
		return productRepository.findAll(userId);
	}
}
