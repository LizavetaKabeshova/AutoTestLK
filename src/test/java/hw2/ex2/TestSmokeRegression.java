package hw2.ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static java.lang.System.setProperty;

public class TestSmokeRegression {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://jdi-framework.github.io/tests");
    }

    @AfterMethod(alwaysRun = true)
    public void turnOff() {
        driver.close();
    }

    @Test(groups = {"regression"})
    public void TestR() {
        WebElement textElement1 = driver.findElement(By.cssSelector(".main-title"));
        Assert.assertTrue(textElement1.isDisplayed());
        WebElement textElement2 = driver.findElement(By.cssSelector(".main-txt"));
        Assert.assertTrue(textElement2.isDisplayed());

    }

    @Test(groups = {"smoke"})
    public void TestS() {
        Assert.assertEquals(driver.getTitle() , "Index Page");
    }

}
