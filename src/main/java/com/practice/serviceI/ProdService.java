package com.practice.serviceI;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.practice.model.Product;

public interface ProdService {
    Page<Product> getAllProducts(Pageable pageable);

    Product addProd(Product prod);

    Product getProdById(int id);

    Product editProd(int id, Product prod);

    void deleteProd(int id);
}

