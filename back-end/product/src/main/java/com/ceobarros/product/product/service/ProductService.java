package com.ceobarros.product.product.service;

import com.ceobarros.product.product.model.Product;
import com.ceobarros.product.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public Iterable<Product> findAllProduct() {
        return productRepository.findAll();
    }

    public Product findProductById(Integer idProduct) {
        Optional<Product> existingProduct = productRepository.findById(idProduct);
        return existingProduct.orElse(null);
    }

    public void addProduct(Product product) {
        LocalDateTime now = LocalDateTime.now();
        product.setCreationDate(now);
        product.setLastChangeDate(now);
        productRepository.save(product);
    }
    public void updateProduct(Integer idProduct, String name, String description, String category, Integer amount, BigDecimal value, Integer idImage) {
        Product product = findProductById(idProduct);
        product.setName(name.isEmpty() ? product.getName() : name);
        product.setDescription(description.isEmpty() ? product.getDescription() : description);
        product.setCategory(category.isEmpty() ? product.getCategory() : category);
        product.setAmount(amount == null ? product.getAmount() : amount);
        product.setValue(value == null ? product.getValue() : value);
        product.setIdImage(idImage == null ? product.getIdImage() : idImage);
        product.setLastChangeDate(LocalDateTime.now());
        productRepository.save(product);
    }

    public void addProductNameDescription(String name, String description) {
        Product product = new Product(name, description);
        productRepository.save(product);
    }
}
