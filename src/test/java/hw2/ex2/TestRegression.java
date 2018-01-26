package hw2.ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.System.setProperty;
import static org.testng.AssertJUnit.assertTrue;

public class TestRegression {

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
    public void testR() {
        List<WebElement> imgElements = driver.findElements(By.cssSelector(".icons-benefit"));
        for (WebElement imgElement : imgElements) {
            assertTrue(imgElement.isDisplayed());
        }
    }
}
