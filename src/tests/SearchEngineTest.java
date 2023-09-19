package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import helper.GoogleHomePage;

public class SearchEngineTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
       // System.setProperty("webdriver.gecko.driver", "/Users/r1.rana/Documents/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void testSearchEngine() {
        String userInput = "hollywood"; // Replace with your desired search query

        GoogleHomePage googleHomePage = new GoogleHomePage(driver);
        googleHomePage.open();
        googleHomePage.searchFor(userInput);

        String actualResult = googleHomePage.getFirstResultText().toLowerCase();
        Assert.assertTrue(actualResult.contains(userInput), "Expected result not found");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
