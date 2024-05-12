package com.alexcojocaru.proiectpwj.repository;

import com.alexcojocaru.proiectpwj.model.Domain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomainRepository extends JpaRepository<Domain, Integer> {
}
