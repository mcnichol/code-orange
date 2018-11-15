package com.codeorange.backendapp;

import org.junit.Test;
import org.springframework.stereotype.Service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class PersonServiceTest {

    PersonRepository mockPersonRepository = mock(PersonRepository.class);
    PersonService subject = new PersonService(mockPersonRepository);

    @Test
    public void isAnnotatedWithServiceStereoType() {
        assertTrue(PersonService.class.isAnnotationPresent(Service.class));
    }

    @Test
    public void getPersonDelegatesToPersonRepository() {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(1);
        personEntity.setName("personEntityName");
        personEntity.setRole("personEntityRole");
        Person expectedPerson = new Person.Builder().name("personEntityName").role("personEntityRole").build();
        when(mockPersonRepository.findByName(expectedPerson.getName().toLowerCase())).thenReturn(personEntity);

        Person actualPerson = subject.getPerson(expectedPerson.getName());

        verify(mockPersonRepository).findByName(expectedPerson.getName().toLowerCase());
        assertThat(actualPerson, equalTo(expectedPerson));
    }


    @Test
    public void getPersonIsCaseInsensitive() {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(1);
        personEntity.setName("personname");
        personEntity.setRole("role");
        Person expectedPerson = new Person.Builder().name("personname").role("role").build();
        when(mockPersonRepository.findByName("personname")).thenReturn(personEntity);

        Person actualPerson = subject.getPerson("PERSONNAME");

        verify(mockPersonRepository).findByName(expectedPerson.getName());
        assertThat(actualPerson, equalTo(expectedPerson));
    }
}