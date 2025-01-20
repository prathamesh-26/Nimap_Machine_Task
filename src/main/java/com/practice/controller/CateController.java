package com.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.practice.model.Category;
import com.practice.serviceI.CateServiceI;

@RestController
@RequestMapping("/api/categories")
public class CateController {

    @Autowired
    CateServiceI categoryService;

    @GetMapping
    public ResponseEntity<Page<Category>> getAllCategories(@RequestParam(defaultValue = "0") int page,
                                                           @RequestParam(defaultValue = "5") int size) {
        Page<Category> categories = categoryService.getAllCategories(PageRequest.of(page, size));
        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.addCate(category));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCateryById(@PathVariable int id) {
        return ResponseEntity.ok(categoryService.getCateById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable int id, @RequestBody Category category) {
        return ResponseEntity.ok(categoryService.editCate(id, category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable int id) {
        categoryService.deleteCate(id);
        return ResponseEntity.noContent().build();
    }
}
