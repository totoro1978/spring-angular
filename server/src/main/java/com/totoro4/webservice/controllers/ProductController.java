package com.totoro4.webservice.controllers;

import static org.springframework.http.ResponseEntity.ok;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.totoro4.webservice.models.Products;
import com.totoro4.webservice.models.User;
import com.totoro4.webservice.repositories.ProductRepository;
import com.totoro4.webservice.services.CustomUserDetailsService;
import com.totoro4.webservice.services.ProductService;

@CrossOrigin(origins = "*")
@RequestMapping("/api")
@RestController
public class ProductController {

	@Autowired
    ProductRepository productRepository;

	@Autowired
	ProductService productService;

	@Autowired
	private CustomUserDetailsService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/products")
    public Iterable<Products> product() {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	User userInfo = userService.findUserByEmail(auth.getName());

    	return productRepository.findAll(userInfo.getId());
    }

    @SuppressWarnings("rawtypes")
    @PostMapping("/products/addProduct")
    public ResponseEntity addProduct(@RequestBody Products product) {

    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	User userInfo = userService.findUserByEmail(auth.getName());
    	product.setUserId(userInfo.getId());
    	productService.addProduct(product);
    
    	Map<Object, Object> model = new HashMap<>();
    	model.put("message", "Product added successfully");
    	return ok(model);
    }
}
