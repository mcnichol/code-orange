package com.codeorange.backendapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private PersonRepository personRepository;

    @Autowired
    PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person getPerson(String name) {
        PersonEntity personEntity = personRepository.findByName(name.toLowerCase());

        Person person = mapEntityToObject(personEntity);

        return person;
    }

    private Person mapEntityToObject(PersonEntity personEntity) {
        return new Person.Builder().role(personEntity.getRole()).name(personEntity.getName()).build();
    }
}
