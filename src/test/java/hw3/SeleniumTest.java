package hw3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class SeleniumTest {

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

    @Test
    public void mainPageTest() {

        // Change search on "xpath"
        // 3 Assert Browser title
        assertEquals(driver.getTitle(), "Index Page");

        // 4 Perform login
        driver.findElement(By.cssSelector(".uui-profile-menu .dropdown-toggle")).click();
        driver.findElement(By.xpath("//*[@id='Login']")).sendKeys("epam");
        driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("1234");
        driver.findElement(By.xpath("//*[@class='form-horizontal']//button")).click();

        // 5 Assert User name in the left-top side of screen that user is loggined
        WebElement userName = driver.findElement(By.xpath("//*[@class='profile-photo']//span"));
        assertEquals(userName.getText(), "PITER CHAILOVSKII");

        // 6 Assert images
        List<WebElement> imgElements = driver.findElements(By.xpath("//*[@class='benefit-icon']"));
        for (WebElement imgElement : imgElements) {
            assertTrue(imgElement.isDisplayed());
        }

        // 7 Assert texts
        List<WebElement> textBoxes = driver.findElements(By.xpath("//*[@class='benefit-txt']"));
        String allTexts = "To include good practices and ideas from successful EPAM projec" +
                "To be flexible and customizable" + "To be multiplatform" + "Already have " +
                "good base (about 20 internal and some external projects), wish to get more…";
        for (WebElement textBoxe : textBoxes) {
            assertTrue(textBoxe.isDisplayed());
            assertTrue(allTexts.contains(textBoxe.getText().replaceAll("\\n", " ")));
        }

        // 8 Assert that there are the main header and the text below it on the Home Page
        assertTrue(driver.findElement(By.xpath("//*[@class='main-content']//h3")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//*[@class='main-content']//p")).isDisplayed());
    }
}
