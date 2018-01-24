package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;

public class DPTest {

    /*
    1.	Develop a dedicated test for asserting 4 texts below 4 pictures on the Index Page
    - https://jdi-framework.github.io/tests/index.htm. The test must be developed with help of the DataProvider.
    Run it in the parallel by methods through the configuring parameters in a @DataProvider annotation.
     */

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
    }

    @AfterMethod(alwaysRun = true)
    public void turnOff() {
        driver.close();
    }

    @DataProvider
    public Object[][] dp() {
        return new Object[][]
                {
                        {0, "To include good practices and ideas from successful EPAM projec"},
                        {1, "To be flexible and customizable"},
                        {2, "To be multiplatform"},
                        {3, "Already have good base (about 20 internal and some external projects), wish to get more…"}
                };
    }

    @Test(dataProvider = "dp")
    public void dpTest(int w, String s) {
        List<WebElement> textBoxes = driver.findElements(By.cssSelector(".benefit-txt"));
        assertEquals(textBoxes.get(w).getText().replaceAll("\\n", " "), s);
    }
}
