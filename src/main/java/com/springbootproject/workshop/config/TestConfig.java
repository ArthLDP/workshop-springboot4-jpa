package com.springbootproject.workshop.config;

import com.springbootproject.workshop.entities.Category;
import com.springbootproject.workshop.entities.Order;
import com.springbootproject.workshop.entities.User;
import com.springbootproject.workshop.entities.enums.OrderStatus;
import com.springbootproject.workshop.repositories.CategoryRepository;
import com.springbootproject.workshop.repositories.OrderRepository;
import com.springbootproject.workshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        Category category1 = new Category(null, "Eletronics");
        Category category2 = new Category(null, "Books");
        Category category3 = new Category(null, "Computers");

        User user1 = new User(null, "John", "john@email.com", "99999999", "123456");
        User user2 = new User(null, "Arthur", "arthur@email.com", "3333333", "123");

        Order order1 = new Order(null, Instant.now(), OrderStatus.PAID, user1);
        Order order2 = new Order(null, Instant.now(), OrderStatus.WAITING_PAYMENT, user2);
        Order order3 = new Order(null, Instant.now(), OrderStatus.WAITING_PAYMENT, user1);

        categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));
    }
}
