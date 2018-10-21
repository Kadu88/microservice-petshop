package com.ceobarros.product.product.repository;

import com.ceobarros.product.product.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {}
