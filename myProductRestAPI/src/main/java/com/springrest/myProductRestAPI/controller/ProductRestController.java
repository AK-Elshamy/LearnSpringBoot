package com.springrest.myProductRestAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.myProductRestAPI.entities.Product;
import com.springrest.myProductRestAPI.repo.ProductRepo;

@RestController
public class ProductRestController {
    @Autowired
    ProductRepo repo;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return repo.findAll();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable int id) {
        return repo.findById(id).orElse(null);
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        return repo.save(product);
    }

    @PutMapping("/products")
    public Product updateProduct(@RequestBody Product product) {
        return repo.save(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable int id) {
        repo.deleteById(id);
    }
}