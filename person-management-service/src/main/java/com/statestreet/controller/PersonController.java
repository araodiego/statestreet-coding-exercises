package com.statestreet.controller;

import org.springframework.web.bind.annotation.RestController;

import com.statestreet.controller.exception.EntityNotFoundException;
import com.statestreet.entity.Gender;
import com.statestreet.entity.Person;
import com.statestreet.service.PersonService;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person createdPerson = personService.createPerson(person);
        return ResponseEntity.ok(createdPerson);
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id) {
        return personService.getPersonById(id)
                            .orElseThrow(() -> new EntityNotFoundException("Person not found with ID: " + id));
    }

    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person updatedPerson) {
        Person existingPerson = personService.getPersonById(id)
                                             .orElseThrow(() -> new EntityNotFoundException("Person not found with ID: " + id));
        updatedPerson.setIdPerson(id);
        return personService.updatePerson(updatedPerson);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersonById(@PathVariable Long id) {
        personService.getPersonById(id)
                     .orElseThrow(() -> new EntityNotFoundException("Person not found with ID: " + id));
        personService.deletePersonById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/searchByName")
    public List<Person> searchPersonsByName(@RequestParam String name) {
        return personService.searchPersonsByName(name)
                            .orElseThrow(() -> new EntityNotFoundException("No persons found with name: " + name));
    }

    @GetMapping("/searchByPartialName")
    public List<Person> searchPersonsByPartialName(@RequestParam String name) {
        return personService.searchPersonsByPartialName(name)
                            .orElseThrow(() -> new EntityNotFoundException("No persons found with partial name: " + name));
    }

    @GetMapping("/searchByGender")
    public List<Person> searchPersonsByGender(@RequestParam String gender) {
        try {
            Gender.GenderType genderType = Gender.GenderType.valueOf(gender.toUpperCase());
            return personService.searchPersonsByGender(genderType)
                                .orElseThrow(() -> new EntityNotFoundException("No persons found with gender: " + gender));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException ("Invalid gender value: " + gender);
        }
    }
}