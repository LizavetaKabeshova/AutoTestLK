package hw3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.System.setProperty;

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
    public void loginTest() {
        Assert.assertEquals(driver.getTitle() , "Index Page");

        /*Doesn't work!?   :(((((((   (the number of second element)
        WebElement a = driver.findElement(By.xpath(("//*[@class='dropdown-toggle'][1]")));
        a.click();

        driver.findElement(By.xpath("//*[@id='Login']")).sendKeys("epam");
        driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("1234");
        driver.findElement(By.xpath("//*[@class='form-horizontal']//button")).click();

        WebElement userName = driver.findElement(By.xpath("//*[@class='profile-photo']//span"));
        Assert.assertEquals(userName.getText(), "PITER CHAILOVSKII");
        */

        List<WebElement> imgElements = driver.findElements(By.xpath("//*[@class='benefit-icon']"));
        for (int i = 0; i < imgElements.size(); i++) {
            Assert.assertTrue(imgElements.get(i).isDisplayed());
        }

        List<WebElement> textBoxes = driver.findElements(By.xpath("//*[@class='benefit-txt']"));
        String[] allTexts = {"To include good practices and ideas from successful EPAM projec",
                "To be flexible and customizable", "To be multiplatform", "Already have " +
                "good base (about 20 internal and some external projects), wish to get more…"};
        for (int i = 0; i < textBoxes.size(); i++) {
            Assert.assertTrue(textBoxes.get(i).isDisplayed());
            Assert.assertEquals(textBoxes.get(i).getText().replaceAll("\\n"," "), allTexts[i]);
        }

        WebElement textElement1 = driver.findElement(By.xpath("//*[@class='main-content']//h3"));
        Assert.assertTrue(textElement1.isDisplayed());
        WebElement textElement2 = driver.findElement(By.xpath("//*[@class='main-content']//p"));
        Assert.assertTrue(textElement2.isDisplayed());

    }
}
