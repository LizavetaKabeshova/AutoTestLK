package hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

// 1 Create a new test in a new Java class, specify test name in
// accordance with checking functionality

public class SeleniumTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2 Open test site by URL
        driver.navigate().to("https://jdi-framework.github.io/tests");
    }

    // 10 close driver
    @AfterMethod(alwaysRun = true)
    public void turnOff() {
        driver.close();
    }

    @Test
    public void loginTest() {

        // 3 Assert Browser title
        assertEquals(driver.getTitle(), "Index Page");

        // 4 Perform login
        driver.findElement(By.xpath("/html/body/div/header/div/nav/ul[2]/li")).click();
        driver.findElement(By.xpath("//*[@id=\"Login\"]")).sendKeys("epam");
        driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("1234");
        driver.findElement(By.xpath("/html/body/div/header/div/nav/ul[2]/li/div/form/button")).click();

        // 5 Assert User name in the left-top side of screen that user is loggined
        WebElement userName = driver.findElement(By.xpath("//*[@class='profile-photo']//span"));
        assertEquals(userName.getText(), "PITER CHAILOVSKII");

        // 6 Assert Browser title
        assertEquals(driver.getTitle(), "Index Page");

        // 7 Assert that there are 4 images on the Home Page and they are displayed
        List<WebElement> imgElements = driver.findElements(By.cssSelector(".icons-benefit"));
        for (WebElement imgElement : imgElements) {
            assertTrue(imgElement.isDisplayed());
        }

        // 8 Assert that there are 4 texts on the Home Page and check them by getting texts
        List<WebElement> textBoxes = driver.findElements(By.cssSelector(".benefit-txt"));
        String allTexts = "To include good practices and ideas from successful EPAM projec" +
                "To be flexible and customizable" + "To be multiplatform" + "Already have " +
                "good base (about 20 internal and some external projects), wish to get more…";
        for (WebElement textBoxe : textBoxes) {
            assertTrue(textBoxe.isDisplayed());
            assertTrue(allTexts.contains(textBoxe.getText().replaceAll("\\n", " ")));
        }

        // 9 Assert that there are the main header and the text below it on the Home Page
        assertTrue(driver.findElement(By.cssSelector(".main-title")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector(".main-txt")).isDisplayed());
    }
}