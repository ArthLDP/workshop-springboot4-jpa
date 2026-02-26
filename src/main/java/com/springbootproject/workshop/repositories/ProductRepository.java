package com.springbootproject.workshop.repositories;

import com.springbootproject.workshop.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}
