package org.sample.service;

import org.sample.mapper.PersonMapper;
import org.sample.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private JdbcTemplate jdbcTemplate;
    private PersonMapper personMapper;

    public PersonService(JdbcTemplate jdbcTemplate, PersonMapper personMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.personMapper = personMapper;
    }

    public List<Person> getAllPersonList(){
        return jdbcTemplate.query("select * from person", personMapper);
    }
}
