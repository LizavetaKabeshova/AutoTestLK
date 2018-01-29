package hw3;

import enums.IndexPageTextBoxesEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.IndexPage;
import static enums.IndexPageEnum.*;
import static enums.IndexPageTextBoxesEnum.getTexts;

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

        // 2 Open test site by URL
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");

        // 3 Assert Browser title
        indexPage.checkTitle(driver);

        // 4 Perform login
        indexPage.login("epam", "1234");

        // 5 Assert User name in the left-top side of screen that user is loggined
        indexPage.checkUser(USER_NAME.text);

        // 6 Assert images
        indexPage.checkIcons();

        // 7 Assert texts
        indexPage.checkTexts(getTexts());

        // 8 Assert that there are the main header and the text below it on the Home Page
        indexPage.checkMainTitle(TEXT_TITLE.text);
        indexPage.checkMainText(TEXT_CONTENT.text);
    }
}