package hw2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


import static java.lang.System.setProperty;

public class SeleniumTest {

    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

    @BeforeTest
    public void beforeTest() {
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println(driver.getTitle());
    }

    @AfterMethod
    public void afterMethod() {
        if (driver.toString().contains("null")) {
            driver.quit();
        }
    }

    @AfterTest
    public void afterTest() {
        System.out.println(System.currentTimeMillis());
    }

    @AfterSuite
    public void afterSuite() {
        driver.close();
    }

    @Test
    public void titleTest() {
        driver.navigate().to("https://jdi-framework.github.io/tests");
        Assert.assertEquals(driver.getTitle(), "Index Page");
    }
}
