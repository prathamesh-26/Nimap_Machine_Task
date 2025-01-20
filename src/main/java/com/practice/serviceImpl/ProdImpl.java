package com.practice.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.practice.model.Category;
import com.practice.model.Product;
import com.practice.repository.CateRepo;
import com.practice.repository.ProdRepo;
import com.practice.serviceI.ProdService;

@Service
public class ProdImpl implements ProdService {

	@Autowired
	ProdRepo pRepo;

	@Autowired
	private CateRepo cRepo;

	@Override
	public Page<Product> getAllProducts(Pageable pageable) {
		return pRepo.findAll(pageable);
	}

	@Override
	public Product addProd(Product product) {
		Category category = cRepo.findById(product.getCategory().getId());
		product.setCategory(category);
		return pRepo.save(product);
	}

	@Override
	public Product getProdById(int id) {
		return pRepo.findById(id);
	}

	@Override
	public Product editProd(int id, Product product) {
		Product existingProduct = getProdById(id);
		existingProduct.setName(product.getName());

		Category category = cRepo.findById(product.getCategory().getId());
		existingProduct.setCategory(category);

		return pRepo.save(existingProduct);
	}

	@Override
	public void deleteProd(int id) {
		pRepo.deleteById(id);
	}
}
