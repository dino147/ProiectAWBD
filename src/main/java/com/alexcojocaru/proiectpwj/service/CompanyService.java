package com.alexcojocaru.proiectpwj.service;

import com.alexcojocaru.proiectpwj.model.Company;
import com.alexcojocaru.proiectpwj.model.Domain;
import com.alexcojocaru.proiectpwj.repository.CompanyRepository;
import com.alexcojocaru.proiectpwj.repository.DomainRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    private final DomainRepository domainRepository;

    public CompanyService(CompanyRepository companyRepository, DomainRepository domainRepository) {
        this.companyRepository = companyRepository;
        this.domainRepository = domainRepository;
    }

    public Company saveCompany(Company company)
    {
        Company savedCompany = companyRepository.save(company);
        log.info("Saving company with id: " + company.getCompanyId());
        return savedCompany;
    }

    public List<Company> retrieveAllCompanies()
    {
        List<Company> companyList = companyRepository.findAll(Sort.by("name"));
        log.info("Retrieved company list with size: " + companyList.size());
        return companyList;
    }

    public List<Company> listCompaniesOnPage(int pageSize, int pageNumber)
    {
        Page<Company> companyPage = companyRepository.findAll(Pageable.ofSize(pageSize).withPage(pageNumber));
        log.info("Listing companies on page " + pageNumber + " with page size " + pageSize);

        return companyPage.get().collect(Collectors.toList());
    }

    public Company findCompanyByName(String name)
    {
        Company company = companyRepository.findCompanyByName(name)
                .orElseThrow(() -> new RuntimeException("Company with name " + name + "not found !"));

        log.info("Company with name " + name + " found with id " + company.getCompanyId());
        return company;
    }

    public void deleteCompanyByName(String name)
    {
        companyRepository.deleteCompanyByName(name);
    }

    public void deleteCompanyById(Long companyId)
    {
        Optional<Company> companyOptional = companyRepository.findById(companyId);
        if(companyOptional.isEmpty())
            throw new RuntimeException("A company with this id doesn't exit !");
        companyRepository.delete(companyOptional.get());
        log.info("Company with id " + companyId + " has been deleted !");
    }

    public List<Company> listCompaniesByType(String type)
    {
        List<Company> companyList = companyRepository.findCompaniesByType(type);
        log.info("Listing companies by type " + type + " number of companies: " + companyList.size());
        return companyList;
    }

    public Company changeCompanyDomain(Long companyId, Domain domain)
    {
        Optional<Company> companyOptional = companyRepository.findById(companyId);

        if(companyOptional.isEmpty())
            throw new RuntimeException("Invalid company id !");

        Company company = companyOptional.get();
        log.info("Changing company " + company.getName() + " " + company.getType() + " domain from "
                + company.getDomain().getCaenCode() + " to: " + domain.getCaenCode());
        company.setDomain(domain);

        return companyRepository.save(company);

    }

    public Domain saveDomain(Domain domain) {
        return domainRepository.save(domain);
    }

    public List<Domain> listAllDomains()
    {
        return domainRepository.findAll();
    }
}
