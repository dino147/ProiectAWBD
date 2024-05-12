package com.alexcojocaru.proiectpwj.controller;

import com.alexcojocaru.proiectpwj.dto.EmployeeDTO;
import com.alexcojocaru.proiectpwj.mapper.EmployeeMapper;
import com.alexcojocaru.proiectpwj.model.Employee;
import com.alexcojocaru.proiectpwj.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    public final EmployeeService employeeService;

    public final EmployeeMapper employeeMapper;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
        this.employeeMapper = new EmployeeMapper();
    }

//    @RequestMapping({"","/", "/home"})
//    public ModelAndView getHome() {
//        return new ModelAndView("main");
//    }

    @RequestMapping({"", "/"})
    public String listEmployees(Model model)
    {
        List<Employee> employeeList = employeeService.listEmployeeOnPage(3, 0);
        model.addAttribute("employees", employeeList);

        return "employeeList";
    }

    @PostMapping("/new")
    public ResponseEntity<Employee> addNewEmployee(@RequestBody @Valid EmployeeDTO employeeDTO)
    {
        Employee employee = employeeService.saveEmployee(employeeMapper.convertRequestToEmployee(employeeDTO));
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/employee/{id}")
                .buildAndExpand(employee.getEmployeeId())
                .toUri();
        return ResponseEntity.created(location)
                .body(employee);
    }


    @GetMapping("/list")
    public ResponseEntity<List<Employee>> listAllEmployees()
    {
        return ResponseEntity.ok().body(employeeService.retrieveAllEmployees());
    }

    @GetMapping("/byFirstName/{firstName}")
    public ResponseEntity<?> findEmployeeByFirstName(@PathVariable String firstName)
    {
        return ResponseEntity.ok().body(employeeService.findEmployeeByFirstName(firstName));
    }

    @GetMapping("/byName/{firstName}/{lastName}")
    public ResponseEntity<?> findEmployeeByFirstAndLastNames(@PathVariable String firstName,
                                                             @PathVariable String lastName)
    {
        return ResponseEntity.ok().body(employeeService.findEmployeeByFirstAndLastNames(firstName, lastName));
    }
}
