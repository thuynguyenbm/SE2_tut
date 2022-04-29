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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/company")
public class CompanyController {
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping(value = "/{id}")
    public String getCompanyById(
            @PathVariable(value = "id") Long id, Model model) {
        Company company = companyRepository.getById(id);
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);
        model.addAttribute("company", company);
        return "companyDetail";
    }

    @RequestMapping(value = "/list")
    public String displayCompanyList(Model model) {
        //get data from db
        List<Company> companies = companyRepository.findAll();

        //send data to FE
        model.addAttribute("companies", companies);

        //render
        return "companyList";
    }

    @RequestMapping( "/add")
    public String addCompany(Model model) {
        Company company = new Company();
        model.addAttribute("companies", company);
        return "companyAdd";
    }

    @RequestMapping("/update/{id}")
    public String updateCompany(
            @PathVariable(value = "id") Long id, Model model) {
        Company company = companyRepository.getById(id);
        model.addAttribute(company);
        return "companyUpdate";
    }

    @RequestMapping("/save")
    public String saveUpdate(
            @RequestParam(value = "id", required = false) Long id,
            @Valid Company company, BindingResult result) {
        if (result.hasErrors()) {
            if (id == null)
                return "companyAdd";
            else
                return "companyUpdate";
        }
        company.setId(id);
        companyRepository.save(company);
        return "redirect:/company/list";
    }

    @RequestMapping( "/delete/{id}")
    public String deleteCompany(
            @PathVariable(value = "id") Long id) {
        Company company = companyRepository.getById(id);
        companyRepository.delete(company);
        return "redirect:/company/list";
    }

    @RequestMapping("/search")
    public String searchCompany(
            Model model,
            @RequestParam(value = "name") String name) {
        List<Company> companies = companyRepository.findByNameContaining(name);
        model.addAttribute("companies", companies);
        return "companyList";
    }

    @RequestMapping("sort/asc")
    public String sortCompany(Model model) {
        List<Company> companies =companyRepository.findAll(Sort.by(Sort.Direction.ASC,"name"));
        model.addAttribute("companies", companies);
        return "companyList";
    }

    @RequestMapping("sort/desc")
    public String sortCompanyDesc(Model model) {
        List<Company> companies =companyRepository.findAll(Sort.by(Sort.Direction.DESC,"name"));
        model.addAttribute("companies", companies);
        return "companyList";
    }
}


