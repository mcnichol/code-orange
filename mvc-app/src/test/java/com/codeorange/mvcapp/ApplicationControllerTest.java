package com.codeorange.mvcapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
public class ApplicationControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    PersonService personService;


    @Test
    public void isAnnotatedWithController() {
        assertTrue(ApplicationController.class.isAnnotationPresent(Controller.class));
    }

    @Test
    public void returnsHelloWorld() throws Exception {
        mockMvc.perform(get("/hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, McNichol")));
    }

    @Test
    public void canAccessFormUrl() throws Exception {
        mockMvc.perform(get("/form"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void canPostForm() throws Exception {

        mockMvc.perform(post("/form")
                .param("name", "userName")
                .param("role", "userRole")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andDo(print())
                .andExpect(status().isFound())
                .andExpect(
                        flash()
                                .attribute("person", hasProperty("name", equalTo("userName"))));
    }

    @Test
    public void delegatesToPersonService() throws Exception {
        Person person = new Person();
        person.setName("userName");
        person.setRole("userRole");

        mockMvc.perform(post("/form")
                .param("name", person.getName())
                .param("role", person.getRole())
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andDo(print())
                .andExpect(status().isFound())
                .andExpect(flash()
                        .attribute("person", hasProperty("name", equalTo("userName"))));

        verify(personService).addPerson(person);
    }



}