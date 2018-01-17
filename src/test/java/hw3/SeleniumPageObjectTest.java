package hw3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.IndexPage;

import java.util.List;

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
    public void test1() {

        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");

        indexPage.login("epam", "1234");

        String urlIcons = "url(\"https://jdi-framework.github.io/tests/images/sprite.png\")";
        indexPage.icons(urlIcons);

        String[] allTexts = {"To include good practices and ideas from successful EPAM projec",
                "To be flexible and customizable", "To be multiplatform", "Already have " +
                "good base (about 20 internal and some external projects), wish to get more…"};
        indexPage.texts(allTexts);

        String title = "EPAM FRAMEWORK WISHES…";
        String mainTxt = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD " +
                "TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD " +
                "EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR " +
                "IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";

        indexPage.checkMainTitle(title);
        indexPage.checkMainTxt(mainTxt);

    }
}