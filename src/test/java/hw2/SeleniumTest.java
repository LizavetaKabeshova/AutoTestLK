package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

import static java.lang.System.setProperty;

public class SeleniumTest {

    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite(){
        setProperty("webdriver.chrome.driver", "chromedriver.exe");
        System.out.println("1");
    }

    @BeforeTest
    public void beforeTest(){
        driver = new ChromeDriver();
        System.out.println("2");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println(driver.getTitle());
        System.out.println("3");
    }

    @AfterMethod
    public void afterMethod(){
        if(driver.toString().contains("null")) { driver.quit(); }
        System.out.println("4");
    }

    @AfterTest
    public void afterTest(){
        System.out.println(System.currentTimeMillis());
        System.out.println("5");
    }

    @AfterSuite
    public void afterSuite() {
        driver.close();
        System.out.println("6");
    }

    @Test
    public void titleTest() {
        driver.navigate().to("https://jdi-framework.github.io/tests");
        Assert.assertEquals(driver.getTitle() , "Index Page");
        System.out.println("test");
    }
}
