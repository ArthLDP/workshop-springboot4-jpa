package com.springbootproject.workshop.config;

import com.springbootproject.workshop.entities.Category;
import com.springbootproject.workshop.entities.Order;
import com.springbootproject.workshop.entities.Product;
import com.springbootproject.workshop.entities.User;
import com.springbootproject.workshop.entities.enums.OrderStatus;
import com.springbootproject.workshop.repositories.CategoryRepository;
import com.springbootproject.workshop.repositories.OrderRepository;
import com.springbootproject.workshop.repositories.ProductRepository;
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

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        Category category1 = new Category(null, "Eletronics");
        Category category2 = new Category(null, "Books");
        Category category3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        User user1 = new User(null, "John", "john@email.com", "99999999", "123456");
        User user2 = new User(null, "Arthur", "arthur@email.com", "3333333", "123");

        Order order1 = new Order(null, Instant.now(), OrderStatus.PAID, user1);
        Order order2 = new Order(null, Instant.now(), OrderStatus.WAITING_PAYMENT, user2);
        Order order3 = new Order(null, Instant.now(), OrderStatus.WAITING_PAYMENT, user1);

        categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        p1.getCategories().add(category2);
        p2.getCategories().add(category1);
        p2.getCategories().add(category3);
        p3.getCategories().add(category3);
        p4.getCategories().add(category3);
        p5.getCategories().add(category2);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));
    }
}
