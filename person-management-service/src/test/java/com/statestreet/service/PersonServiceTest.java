package com.statestreet.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import com.statestreet.entity.Gender;
import com.statestreet.entity.Person;

@SpringBootTest
@AutoConfigureTestDatabase
public class PersonServiceTest {

    @Autowired
    private PersonService personService;
    
    private Gender male;
    private Gender female;
    private Gender other;

    @BeforeEach
    public void setup() {
        male = new Gender(Gender.GenderType.MALE);
        female = new Gender(Gender.GenderType.FEMALE);
        other = new Gender(Gender.GenderType.OTHER);
    }    

    @Test
    public void testSaveAndRetrievePerson() {
        Person person = new Person();
        person.setFullName("John Doe");        
        person.setGender(male);
        
        Person savedPerson = personService.createPerson(person);
      
        Person retrievedPerson = personService.getPersonById(savedPerson.getIdPerson()).orElse(null);

        assertThat(retrievedPerson).isNotNull();
        assertThat(retrievedPerson.getFullName()).isEqualTo("John Doe");
    }

    @Test
    public void testUpdatePerson() {
        Person person = new Person();
        person.setFullName("Alice Johnson");
        person.setGender(female);
        
        Person savedPerson = personService.createPerson(person);

        savedPerson.setFullName("Updated Name");
        personService.updatePerson(savedPerson);
  
        Person retrievedPerson = personService.getPersonById(savedPerson.getIdPerson()).orElse(null);

        assertThat(retrievedPerson).isNotNull();
        assertThat(retrievedPerson.getFullName()).isEqualTo("Updated Name");
    }

    @Test
    public void testDeletePerson() {        
        Person person = new Person();
        person.setFullName("Mark Johnson");
        person.setGender(other);
        
        Person savedPerson = personService.createPerson(person);
        
        personService.deletePersonById(savedPerson.getIdPerson());

        Person retrievedPerson = personService.getPersonById(savedPerson.getIdPerson()).orElse(null);
        
        assertThat(retrievedPerson).isNull();
    }
    
    @Test
    public void testGetPersonByName() {       

		Person mark = new Person();
		mark.setFullName("Mark Johnson");
		mark.setGender(male);        

		Person alice = new Person();
		alice.setFullName("Alice Johnson");
		alice.setGender(female);        

        Person john = new Person();
        john.setFullName("John Doe");        
        john.setGender(male);
        
        personService.createPerson(john);
        personService.createPerson(alice);
        personService.createPerson(mark);

        List<Person> persons =  personService.searchPersonsByName("Mark Johnson").orElse(null);
        boolean match =  persons.stream().allMatch(p->p.getFullName().equals("Mark Johnson"));
        assertThat(match).isTrue();
    }
    
    @Test
    public void testGetPersonByPartialName() {      

		Person mark = new Person();
		mark.setFullName("Mark Johnson");
		mark.setGender(male);       

		Person markDoe = new Person();
		markDoe.setFullName("Mark Doe");
		markDoe.setGender(male);

        Person john = new Person();
        john.setFullName("John Doe");        
        john.setGender(male);
        
        personService.createPerson(john);
        personService.createPerson(markDoe);
        personService.createPerson(mark);
        
        List<Person> persons = personService.searchPersonsByPartialName("Mark").orElse(null);
        boolean match =  persons.stream().anyMatch(p->p.getFullName().equals("Mark Johnson"));
        assertThat(match).isTrue();
    }
    
    @Test
    public void testGetPersonByGender() {
		Person mark = new Person();
		mark.setFullName("Mark Johnson");
		mark.setGender(male);
        
		Person alice = new Person();
		alice.setFullName("Alice");
		alice.setGender(female);        
        
        Person john = new Person();
        john.setFullName("John Doe");        
        john.setGender(male);
        
        personService.createPerson(john);
        personService.createPerson(alice);
        personService.createPerson(mark);        
        
        List<Person> persons = personService.searchPersonsByGender(Gender.GenderType.FEMALE).orElse(null);
        boolean match =  persons.stream().anyMatch(p->p.getFullName().equals("Alice"));
        assertThat(match).isTrue();
    }
}
