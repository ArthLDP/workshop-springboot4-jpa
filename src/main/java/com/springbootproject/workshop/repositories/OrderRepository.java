package com.springbootproject.workshop.repositories;

import com.springbootproject.workshop.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long>{}