package com.alexcojocaru.proiectpwj.repository;

import com.alexcojocaru.proiectpwj.model.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

// already extends PagingAndSortingRepository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    public Optional<Company> findCompanyByName(String companyName);

    public List<Company> findCompaniesByType(String type);

    public void deleteCompanyByName(String companyName);

}
