package org.sample.unit.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sample.config.DatabaseConfig;
import org.sample.mapper.PersonMapper;
import org.sample.model.Person;
import org.sample.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@Import(DatabaseConfig.class)
public class PersonServiceTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private PersonService personService;

    @Before
    public void setUp(){
        personService = new PersonService(jdbcTemplate, new PersonMapper());
    }

    @Test
    public void testGetAllPersonList() {
        List<Person> list =  personService.getAllPersonList();
        Assert.assertEquals(4, list.size());
    }
}