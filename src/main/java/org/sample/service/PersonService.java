package org.sample.service;

import org.sample.mapper.PersonMapper;
import org.sample.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private Logger logger = LoggerFactory.getLogger(PersonService.class);

    private JdbcTemplate jdbcTemplate;
    private PersonMapper personMapper;

    public PersonService(JdbcTemplate jdbcTemplate, PersonMapper personMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.personMapper = personMapper;
    }

    public List<Person> getAllPersonList(){
        logger.info("Getting Person List Now !!!!!!!!");
        logger.info("Person Service Debugging info!!!!!");
        return jdbcTemplate.query("select * from person", personMapper);
    }
}
