package com.springbootproject.workshop.repositories;

import com.springbootproject.workshop.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {}
