package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * ProductService — business logic layer for products.
 *
 * YOUR TASK (Part B):
 *   1. Add constructor injection for ProductRepository
 *   2. Implement all 5 methods below
 *
 * Follow the same pattern from the BookService in Day 2:
 *   - Constructor takes the repository as a parameter
 *   - Each method delegates to the repository
 */
@Service
public class ProductService {

    // TODO: Declare a private final ProductRepository field
    private final ProductRepository repository;

    // TODO: Constructor that takes ProductRepository as parameter (constructor injection)
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    /**
     * Get all products.
     */
    public List<Product> getAllProducts() {
        // TODO: Delegate to repository
        return repository.findAll();
    }

    /**
     * Get a product by ID.
     * Returns Optional<Product> — empty if not found.
     */
    public Optional<Product> getProductById(Long id) {
        // TODO: Delegate to repository
        return repository.findById(id);
    }

    /**
     * Create a new product.
     * @return the saved product (with generated ID)
     */
    public Product createProduct(Product product) {
        // TODO: Delegate to repository
        return repository.save(product);
    }

    /**
     * Update an existing product.
     * Find the existing product by ID, update its fields, and save it.
     *
     * @return Optional containing the updated product, or empty if not found
     */
    public Optional<Product> updateProduct(Long id, Product updated) {
        // TODO: Find existing product by ID
        Optional<Product> prd = repository.findById(id);

        // TODO: If found, update its name, category, price, and quantity
        if (prd.isPresent()) {
            Product existing = prd.get();

            existing.setName(updated.getName());
            existing.setCategory(updated.getCategory());
            existing.setPrice(updated.getPrice());
            existing.setQuantity(updated.getQuantity());

            // TODO: Save and return the updated product
            Product saved = repository.save(existing);

            return Optional.of(saved);
        }

        // TODO: If not found, return Optional.empty()
        return Optional.empty();
    }

    /**
     * Delete a product by ID.
     * @return true if deleted, false if not found
     */
    public boolean deleteProduct(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return  false;
    }
}
