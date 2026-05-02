package com.springrest.myProductRestAPI.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.myProductRestAPI.entities.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {
}