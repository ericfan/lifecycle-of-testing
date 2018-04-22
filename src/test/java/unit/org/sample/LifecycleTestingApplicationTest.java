package unit.org.sample;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sample.LifecycleTestingApplication;
import org.sample.controller.HomeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Test case for {@link LifecycleTestingApplication}
 * Start a Spring application context and ensure {@link HomeController} is loaded.
 *
 * @author Eric Fan
 * @since 21/04/2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {LifecycleTestingApplication.class})
public class LifecycleTestingApplicationTest {

    @Autowired
    private HomeController homeController;

    @Test
    public void testContextLoads() {
        Assert.assertNotNull(homeController);
    }
}