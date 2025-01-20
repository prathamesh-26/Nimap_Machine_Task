package com.practice.serviceI;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.practice.model.Category;

public interface CateServiceI {
    Page<Category> getAllCategories(Pageable pageable);

    Category addCate(Category cate);

    Category getCateById(int id);

    Category editCate(int id, Category cate);

    void deleteCate(int id);
}

