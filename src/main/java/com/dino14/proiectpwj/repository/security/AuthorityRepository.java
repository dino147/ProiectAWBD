package com.dino14.proiectpwj.repository.security;

import com.dino14.proiectpwj.model.security.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
