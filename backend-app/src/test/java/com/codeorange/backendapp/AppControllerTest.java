package com.codeorange.backendapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RestController;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AppControllerTest {

    private MockMvc mockMvc;
    private PersonService mockPersonService = mock(PersonService.class);

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new AppController(mockPersonService)).build();
    }

    @Test
    public void isAnnotatedWithRestController() {
        assertTrue(AppController.class.isAnnotationPresent(RestController.class));
    }

    @Test
    public void canGetUserAndRole() throws Exception {
        ObjectMapper om = new ObjectMapper();
        Person person = new Person.Builder().name("Code Orange").role("Rockstar").build();
        when(mockPersonService.getPerson(person.getName())).thenReturn(person);

        mockMvc.perform(get("/users/{name}", person.getName()))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(om.writeValueAsString(person))));

        verify(mockPersonService).getPerson(person.getName());
    }
}