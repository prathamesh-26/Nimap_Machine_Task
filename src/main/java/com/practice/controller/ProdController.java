package com.practice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.practice.model.Product;
import com.practice.serviceI.ProdService;

@RestController
@RequestMapping("/api/products")
public class ProdController {

    @Autowired
    ProdService pSer;

    @GetMapping
    public ResponseEntity<Page<Product>> getAllProducts(@RequestParam(defaultValue = "0") int page,
                                                        @RequestParam(defaultValue = "10") int size) {
        Page<Product> products = pSer.getAllProducts(PageRequest.of(page, size));
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return ResponseEntity.ok(pSer.addProd(product));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProdById(@PathVariable int id) {
        return ResponseEntity.ok(pSer.getProdById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> editProd(@PathVariable int id, @RequestBody Product product) {
        return ResponseEntity.ok(pSer.editProd(id, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProd(@PathVariable int id) {
    	pSer.deleteProd(id);
        return ResponseEntity.noContent().build();
    }
}
