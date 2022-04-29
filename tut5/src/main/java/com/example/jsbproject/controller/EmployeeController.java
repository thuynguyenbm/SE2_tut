package com.example.jsbproject.controller;

import com.example.jsbproject.model.Company;
import com.example.jsbproject.model.Employee;
import com.example.jsbproject.repository.CompanyRepository;
import com.example.jsbproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    CompanyRepository companyRepository;

    @RequestMapping("/list")
    public String displayEmployeeList(Model model) {
        //get data from db
        List<Employee> employeeList = employeeRepository.findAll();

        //send data to FE
        model.addAttribute("employees", employeeList);

        //render
        return "employeeList";
    }

    @RequestMapping("/{id}")
    public String getEmployeeById(
            @PathVariable(value = "id") Long id, Model model) {
        Employee employee = employeeRepository.getById(id);
        model.addAttribute("employee", employee);
        return "employeeDetails";
    }

    @RequestMapping( "/add")
    public String addEmployee(Model model) {
        Employee employee = new Employee();
        List<Company> companies = companyRepository.findAll();
        model.addAttribute("companies", companies);
        model.addAttribute("employee", employee);
        return "employeeAdd";
    }

    @RequestMapping("/update/{id}")
    public String updateEmployee(
            @PathVariable(value = "id") Long id, Model model) {
        Employee employee = employeeRepository.getById(id);
        List<Company> companies = companyRepository.findAll();
        model.addAttribute("companies", companies);
        model.addAttribute(employee);
        return "employeeUpdate";
    }

    @RequestMapping("/save")
    public String saveUpdate(
            @RequestParam(value = "id", required = false) Long id,
            @Valid Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            if (id == null)
                return "employeeAdd";
            else
                return "employeeUpdate";
        }
        employee.setId(id);
        employeeRepository.save(employee);
        return "redirect:/employee/list";
    }

    @RequestMapping( "/delete/{id}")
    public String deleteEmployee(
            @PathVariable(value = "id") Long id) {
        Employee employee = employeeRepository.getById(id);
        employeeRepository.delete(employee);
        return "redirect:/employee/list";
    }

    @RequestMapping("/search")
    public String searchEmployee(
            Model model,
            @RequestParam(value = "name") String name) {
        List<Employee> employees = employeeRepository.findByNameContaining(name);
        model.addAttribute("employees", employees);
        return "employeeList";
    }

    @RequestMapping("sort/asc")
    public String sortEmployee(Model model) {
        List<Employee> employees =employeeRepository.findAll(Sort.by(Sort.Direction.ASC,"name"));
        model.addAttribute("employees", employees);
        return "employeeList";
    }

    @RequestMapping("sort/desc")
    public String sortEmployeeDesc(Model model) {
        List<Employee> employees =employeeRepository.findAll(Sort.by(Sort.Direction.DESC,"name"));
        model.addAttribute("employees", employees);
        return "employeeList";
    }
}
