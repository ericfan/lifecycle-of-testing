package org.sample.automation;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Automation test using selenium.
 *
 * @author Eric Fan
 * @since 22/04/2018
 */
public class LifeCytleAutomationTest {

    private static WebDriver webDriver;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "../../src/test/resources/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.get("http://localhost:8080");
    }

    @Test
    public void uiTest() {
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        List<WebElement> list = webDriver.findElements(By.cssSelector("div[aria-rowindex='2']"));
        Assert.assertEquals("woody", list.get(1).getText());
    }

    @AfterClass
    public static void tearDown() {
        webDriver.quit();
    }
}
