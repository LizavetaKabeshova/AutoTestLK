package hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;


import static java.lang.System.setProperty;
public class SeleniumTest {

    /* 1 Create a new test in a new Java class, specify test name in
    accordance with checking functionality
    2 Open test site by URL */
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://jdi-framework.github.io/tests");
    }
    // 10 close driver
    @AfterMethod(alwaysRun = true)
    public void turnOff() {
        driver.close();
    }

    @Test
    public void loginTest() {
        //3 Assert Browser title
        Assert.assertEquals(driver.getTitle() , "Index Page");

        //4 Perform login
        //driver.manage().deleteAllCookies();
        //driver.manage().addCookie(new Cookie("epam", "1234"));
        driver.findElement(By.xpath("/html/body/div/header/div/nav/ul[2]/li")).click();
        driver.findElement(By.xpath("//*[@id=\"Login\"]")).sendKeys("epam");
        driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("1234");
        driver.findElement(By.xpath("/html/body/div/header/div/nav/ul[2]/li/div/form/button")).click();

        //5 Assert User name in the left-top side of screen that user is loggined
        WebElement userName1 = driver.findElement(By.xpath("//*[@class='profile-photo']//span"));
        Assert.assertEquals(userName1.getText(), "PITER CHAILOVSKII");

        //6 Assert Browser title
        Assert.assertEquals(driver.getTitle() , "Index Page");

        //7 Assert that there are 4 images on the Home Page and they are displayed
        //This logic for meaning "there are 4 images & they are displayed"
        List<WebElement> imgElements = driver.findElements(By.cssSelector(".icons-benefit"));
        for (int i = 0; i < imgElements.size(); i++) {
            Assert.assertTrue(imgElements.get(i).isDisplayed());
            Assert.assertEquals(imgElements.get(i).getCssValue("background-image"),
                    "url(\"https://jdi-framework.github.io/tests/images/sprite.png\")");
        }

        //This logic for meaning "there are 4 different images & they are displayed"
        //There are no any url in html code. There is class "icons-benefit" with one image
        //"https://jdi-framework.github.io/tests/images/sprite.png" for 4 divs .
        //The differents beetween them are in another classes, in values position and width - it's
        //the way to verife the correctness of the picture.
        WebElement imgPractise = driver.findElement(By.cssSelector(".icon-practise"));
        Assert.assertTrue(imgPractise.isDisplayed());
        Assert.assertEquals(imgPractise.getCssValue("background-position"), "-1px -22px");

        WebElement imgCustom = driver.findElement(By.cssSelector(".icon-custom"));
        Assert.assertTrue(imgCustom.isDisplayed());
        Assert.assertEquals(imgCustom.getCssValue("background-position"), "-69px -22px");

        WebElement imgMulti = driver.findElement(By.cssSelector(".icon-multi"));
        Assert.assertTrue(imgMulti.isDisplayed());
        Assert.assertEquals(imgMulti.getCssValue("background-position"), "-152px -22px");

        WebElement imgBase = driver.findElement(By.cssSelector(".icon-base"));
        Assert.assertTrue(imgBase.isDisplayed());
        Assert.assertEquals(imgBase.getCssValue("background-position"), "-242px -22px");

        //8 Assert that there are 4 texts on the Home Page and check them by getting texts
        List<WebElement> textBoxes = driver.findElements(By.cssSelector(".benefit-txt"));
        String[] allTexts = {"To include good practices and ideas from successful EPAM projec",
                "To be flexible and customizable", "To be multiplatform", "Already have " +
                "good base (about 20 internal and some external projects), wish to get more…"};
        for (int i = 0; i < textBoxes.size(); i++) {
            Assert.assertTrue(textBoxes.get(i).isDisplayed());
            Assert.assertEquals(textBoxes.get(i).getText().replaceAll("\\n"," "), allTexts[i]);
        }

        //9 Assert that there are the main header and the text below it on the Home Page
        WebElement textElement1 = driver.findElement(By.cssSelector(".main-title"));
        Assert.assertTrue(textElement1.isDisplayed());
        WebElement textElement2 = driver.findElement(By.cssSelector(".main-txt"));
        Assert.assertTrue(textElement2.isDisplayed());

    }
}
