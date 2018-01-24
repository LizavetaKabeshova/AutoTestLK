package hw2.ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class TestSmoke {

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

    @Test(groups = {"smoke"})
    public void TestS() {
        List<WebElement> textBoxes = driver.findElements(By.cssSelector(".benefit-txt"));
        String[] allTexts = {"To include good practices and ideas from successful EPAM projec",
                "To be flexible and customizable", "To be multiplatform", "Already have " +
                "good base (about 20 internal and some external projects), wish to get more…"};
        for (int i = 0; i < textBoxes.size(); i++) {
            assertTrue(textBoxes.get(i).isDisplayed());
            assertEquals(textBoxes.get(i).getText().replaceAll("\\n", " "), allTexts[i]);
        }
    }
}
