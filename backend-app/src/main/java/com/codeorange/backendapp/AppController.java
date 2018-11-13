package com.codeorange.backendapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    private PersonService personService;

    @Autowired
    public AppController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/user/{name}")
    public ResponseEntity<Person> getUser(@PathVariable String name) {
        Person person = personService.getPerson(name);

        return new ResponseEntity<>(person, HttpStatus.OK);
    }
}
