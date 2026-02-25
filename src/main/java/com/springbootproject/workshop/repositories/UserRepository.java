package com.springbootproject.workshop.repositories;

import com.springbootproject.workshop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
