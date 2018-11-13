package com.codeorange.backendapp;

import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private PersonRepository personRepository;

    PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person getPerson(String name) {
        PersonEntity personEntity = personRepository.findByName(name);

        Person person = new Person.Builder().role(personEntity.getRole()).name(personEntity.getName()).build();

        return person;
    }
}
