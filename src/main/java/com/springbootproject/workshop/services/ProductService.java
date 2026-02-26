package com.springbootproject.workshop.services;

import com.springbootproject.workshop.entities.Product;
import com.springbootproject.workshop.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> object = productRepository.findById(id);
        if (object.isPresent()) {
            return object.get();
        }

        throw new EntityNotFoundException("Product not found with id: " + id);
    }
}
