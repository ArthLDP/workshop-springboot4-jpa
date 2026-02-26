package com.springbootproject.workshop.repositories;

import com.springbootproject.workshop.entities.OrderItem;
import com.springbootproject.workshop.entities.pk.OrderItemPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk> {}
