package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.model.Category;


@Repository
public interface CateRepo extends JpaRepository<Category, Integer>{
	Category findById(int id);
}
