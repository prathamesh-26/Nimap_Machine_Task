package com.practice.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.practice.model.Category;
import com.practice.repository.CateRepo;
import com.practice.serviceI.CateServiceI;

@Service
public class CateImpl implements CateServiceI {

    @Autowired
    CateRepo categoryRepository;

    @Override
    public Page<Category> getAllCategories(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Category addCate(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category getCateById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category editCate(int id, Category category) {
        Category existingCategory = getCateById(id);
        existingCategory.setCname(category.getCname());
        return categoryRepository.save(existingCategory);
    }

    @Override
    public void deleteCate(int id) {
        categoryRepository.deleteById(id);
    }

	
}
