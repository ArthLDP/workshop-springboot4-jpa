package com.springbootproject.workshop.services;

import com.springbootproject.workshop.entities.Order;
import com.springbootproject.workshop.repositories.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> object = orderRepository.findById(id);

        if (object.isPresent()) {
            return object.get();
        }
        throw new EntityNotFoundException("Order not found with id " + id);
    }
}
