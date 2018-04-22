package org.sample.unit.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.sample.mapper.PersonMapper;
import org.sample.service.PersonService;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

/**
 * Test case for {@link PersonService}.
 * This test case is a strict unit test case, it just test itself, all dependencies are mocked.
 * However, I think it makes no sense if write unit test like this.
 *
 * @author Eric Fan
 * @since 22/04/2018
 */
@RunWith(MockitoJUnitRunner.class)
public class PersonServiceDeprecatedTest {

    @Mock
    private JdbcTemplate jdbcTemplate;
    @Mock
    private PersonMapper personMapper;

    @InjectMocks
    private PersonService svc;

    @Test
    public void testGetAllPersonList() {
        svc.getAllPersonList();
        verify(jdbcTemplate).query(anyString(), any(PersonMapper.class));
    }
}