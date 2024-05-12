package com.dino14.proiectpwj.controller;

import com.dino14.proiectpwj.dto.CompanyDTO;
import com.dino14.proiectpwj.dto.DomainDTO;
import com.dino14.proiectpwj.mapper.DomainMapper;
import com.dino14.proiectpwj.model.Company;
import com.dino14.proiectpwj.model.Domain;
import com.dino14.proiectpwj.service.CompanyService;
import jakarta.validation.Valid;
import com.dino14.proiectpwj.mapper.CompanyMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/company")
public class CompanyController {

    public final CompanyService companyService;

    public final CompanyMapper companyMapper;

    private final DomainMapper domainMapper;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
        this.companyMapper = new CompanyMapper();
        this.domainMapper = new DomainMapper();
    }

    @RequestMapping({"", "/"})
    public String companyList(Model model)
    {
        List<Company> companyList = companyService.listCompaniesOnPage(10, 0);
        model.addAttribute("companies", companyList);
        return "companyList";
    }

    @RequestMapping("/form")
    public String companyForm(Model model)
    {
        Company company = new Company();
        model.addAttribute("company", company);
        List<Domain> domainsAll = companyService.listAllDomains();
        model.addAttribute("domainsAll", domainsAll);

        return "companyForm";
    }

    @PostMapping("")
    public String addNewCompany(@ModelAttribute @Valid CompanyDTO companyDTO)
    {
        companyService.saveCompany(companyMapper.convertRequestToCompany(companyDTO));

        return "redirect:/company";
//        return ResponseEntity.ok()
//                .body(companyService.saveCompany(companyMapper.convertRequestToCompany((companyDTO))));
    }

    @RequestMapping("/delete/{id}")
    public String deleteById(@PathVariable String id)
    {
        companyService.deleteCompanyById(Long.valueOf(id));

        return "redirect:/company";
    }

    @GetMapping("/list")
    public ResponseEntity<List<Company>> listAllCompanies()
    {
        return ResponseEntity.ok().body(companyService.retrieveAllCompanies());
    }

    @GetMapping("/byName/{companyName}")
    public ResponseEntity<?> findCompanyByName(@PathVariable String companyName)
    {
        return ResponseEntity.ok().body(companyService.findCompanyByName(companyName));
    }

    @GetMapping("/byType/{type}")
    public ResponseEntity<?> listCompaniesByType(@PathVariable String type)
    {
        return ResponseEntity.ok().body(companyService.listCompaniesByType(type));
    }

    @PutMapping("/domain/{companyId}")
    public ResponseEntity<?> changeCompanyDomain(@RequestBody DomainDTO domainDTO, @PathVariable Long companyId) {
        Company company = companyService.changeCompanyDomain(companyId, domainMapper.convertRequestToDomain(domainDTO));
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/domain/{id}")
                .buildAndExpand(companyId)
                .toUri();
        return ResponseEntity.ok().body(company);
    }

    @PostMapping("/domain/new")
    public ResponseEntity<?> changeCompanyDomain(@RequestBody DomainDTO domainDTO) {
        Domain domain = companyService.saveDomain(domainMapper.convertRequestToDomain(domainDTO));
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/invoice/{id}")
                .buildAndExpand(domain.getDomainId())
                .toUri();
        return ResponseEntity.ok().body(domain);
    }
}
