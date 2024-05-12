package com.alexcojocaru.proiectpwj.repository.security;

import com.alexcojocaru.proiectpwj.model.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
