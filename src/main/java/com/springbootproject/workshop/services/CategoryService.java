package com.springbootproject.workshop.services;

import com.springbootproject.workshop.entities.Category;
import com.springbootproject.workshop.repositories.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> object = categoryRepository.findById(id);

        if (object.isPresent()) {
            return object.get();
        }
        throw new EntityNotFoundException("Category not found with id " + id);
    }
}
