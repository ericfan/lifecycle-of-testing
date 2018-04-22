package org.sample.unit.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sample.controller.PersonController;
import org.sample.model.Person;
import org.sample.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test case for {@link PersonController}.
 * Use {@link WebMvcTest}, means Spring Boot is only instantiating the web layer, not the whole context.
 * In an application with multiple controllers you can even ask for just one to be instantiated.
 *
 * @author Eric Fan
 * @since 21/04/2018
 */
@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;

    @Test
    public void testGetPersons() throws Exception {
        when(personService.getAllPersonList()).thenReturn(Arrays.asList(new Person(1, "ut", 10)));
        mockMvc.perform(get("/persons"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("ut")))
                .andExpect(jsonPath("$[0].age", is(10)));
    }
}