package com.alexcojocaru.proiectpwj.repository.security;

import com.alexcojocaru.proiectpwj.model.security.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
