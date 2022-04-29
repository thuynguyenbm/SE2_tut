package com.example.demo.controller;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    PersonRepository personRepository;


    @GetMapping(value = "/")
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Person getPersonById(
            @PathVariable(value = "id") Long id
    ) {
        if (personRepository.existsById(id)) {
            Person person = personRepository.findById(id).get();
            return person;
        } else
            return null;
    }

    @PostMapping(value = "/")
    public String addPerson(
            @RequestBody Person person
    ) {
        personRepository.save(person);
        return "Added successfully!";
    }

    @PutMapping(value = "/{id}")
    public String updatePerson(
            @PathVariable(value = "id") Long id,
            @RequestBody Person person
    ) {
        if (personRepository.existsById(id)) {
            person.setId(id);
            personRepository.save(person);
            return "Updated successfully!";
        } else
            return "This person doesn't exist!";
    }

    @DeleteMapping(value = "/{id}")
    public String deletePerson(
            @PathVariable(value = "id") Long id
    ) {
        Person person = personRepository.getById(id);
        if (personRepository.existsById(id)) {
            personRepository.delete(person);
            return "Deleted successfully!";
        } else
            return "This person doesn't exist!";
    }
}
