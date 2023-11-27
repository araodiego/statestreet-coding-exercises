package com.statestreet.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.statestreet.controller.exception.EntityNotFoundException;
import com.statestreet.entity.Gender;
import com.statestreet.entity.Person;
import com.statestreet.service.PersonService;

@Controller
@RequestMapping("/persons")
public class PersonThymeleafController {

    private final PersonService personService;

    @Autowired
    public PersonThymeleafController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public String viewPerson(@PathVariable Long id, Model model) {
        Person person = personService.getPersonById(id)
                                      .orElseThrow(() -> new EntityNotFoundException("Person not found with ID: " + id));
        model.addAttribute("person", person);
        return "view";
    }

    @GetMapping("/create")
    public String createPersonForm(Model model) {
        model.addAttribute("person", new Person());
        return "create";
    }

    @PostMapping("/create")
    public String createPersonSubmit(@ModelAttribute Person person) {
        personService.createPerson(person);
        return "redirect:/persons";
    }

    @GetMapping("/{id}/edit")
    public String editPersonForm(@PathVariable Long id, Model model) {
        Person person = personService.getPersonById(id)
                                      .orElseThrow(() -> new EntityNotFoundException("Person not found with ID: " + id));
        model.addAttribute("person", person);
        return "edit";
    }

    @PostMapping("/{id}/edit")
    public String editPersonSubmit(@PathVariable Long id, @ModelAttribute Person updatedPerson) {
        Person existingPerson = personService.getPersonById(id)
                                             .orElseThrow(() -> new EntityNotFoundException("Person not found with ID: " + id));
        updatedPerson.setIdPerson(id);
        personService.updatePerson(updatedPerson);
        return "redirect:/persons";
    }

    @GetMapping("/{id}/delete")
    public String deletePersonForm(@PathVariable Long id, Model model) {
        Person person = personService.getPersonById(id)
                                      .orElseThrow(() -> new EntityNotFoundException("Person not found with ID: " + id));
        model.addAttribute("person", person);
        return "delete";
    }

    @PostMapping("/{id}/delete")
    public String deletePersonSubmit(@PathVariable Long id) {
        personService.deletePersonById(id);
        return "redirect:/persons";
    }

    @GetMapping
    public String listPersons(Model model) {
        List<Person> persons = personService.getAllPersons().orElse(null);
        model.addAttribute("persons", persons);
        return "list";
    }
    
    @GetMapping("/searchByPartialName")
    public String searchByPartialName(@RequestParam(required = false) String name, Model model) {
        if (name != null && !name.isEmpty()) {
            List<Person> persons = personService.searchPersonsByPartialName(name).orElse(Collections.emptyList());
            model.addAttribute("persons", persons);
        }
        return "searchByPartialName"; 
    }
    
    @GetMapping("/searchByGender")
    public String searchByGender(@RequestParam(required = false) String gender, Model model) {
        if (gender != null && !gender.isEmpty()) {
            List<Person> persons = personService.searchPersonsByGender(Gender.GenderType.valueOf(gender.toUpperCase())).orElse(Collections.emptyList());
            model.addAttribute("persons", persons);
        }
        return "searchByGender";
    }
}