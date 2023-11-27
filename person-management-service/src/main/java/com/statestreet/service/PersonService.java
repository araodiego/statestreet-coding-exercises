package com.statestreet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.statestreet.entity.Gender;
import com.statestreet.entity.Person;
import com.statestreet.repository.PersonRepository;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    // Create a new Person
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    // Get a Person by ID
    public Optional<Person> getPersonById(Long id) {
        return personRepository.findById(id);
    }

    // Update a Person
    public Person updatePerson(Person updatedPerson) {
        return personRepository.save(updatedPerson);
    }

    // Delete a Person by ID
    public void deletePersonById(Long id) {
        personRepository.deleteById(id);
    }

    // Search for Persons by name
    public Optional<List<Person>> searchPersonsByName(String name) {
        return personRepository.findByFullName(name);
    }
    
    // Search for Persons by partial name
    public Optional<List<Person>> searchPersonsByPartialName(String name) {
        return personRepository.findByFullNameContainingIgnoreCase(name);
    }
    
    // Search for Persons by gender
    public Optional<List<Person>> searchPersonsByGender(Gender.GenderType genderType) {
        return personRepository.findByGender_IdGender(genderType.getId());
    }

    // Return all Persons
    public Optional<List<Person>> getAllPersons(){
    	 List<Person> persons = personRepository.findAll();
         return Optional.ofNullable(persons);
    }
}
