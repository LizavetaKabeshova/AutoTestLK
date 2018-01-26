package hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.IndexPage;
import static enums.IndexPageEnum.*;

public class SeleniumPageObjectTest {

    private WebDriver driver;
    private IndexPage indexPage;

    @BeforeClass
    public void setUpPages() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        indexPage = PageFactory.initElements(driver, IndexPage.class);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }

    @Test
    public void mainPageTest() {

        // Open test site by URL
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");

        // Assert Browser title
        indexPage.checkTitle(driver);

        // Perform login
        indexPage.login("epam", "1234");

        // Assert User name in the left-top side of screen that user is loggined
        indexPage.checkUser(USER_NAME.text);

        // Assert images
        String urlIcons = "url(\"https://jdi-framework.github.io/tests/images/sprite.png\")";
        indexPage.checkIcons(urlIcons);

        // Assert texts
        indexPage.checkTexts(getTexts());

        // Assert that there are the main header and the text below it on the Home Page
        indexPage.checkMainTitle(TEXT_TITLE.text);
        indexPage.checkMainText(TEXT_CONTENT.text);
    }
}