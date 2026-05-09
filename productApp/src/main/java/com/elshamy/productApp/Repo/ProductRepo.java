package com.elshamy.productApp.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elshamy.productApp.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
}