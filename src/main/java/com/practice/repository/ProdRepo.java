package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.model.Product;

@Repository
public interface ProdRepo extends JpaRepository<Product, Integer> {
	Product findById(int id);
}
