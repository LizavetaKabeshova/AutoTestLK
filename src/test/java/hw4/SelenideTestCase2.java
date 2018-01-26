package hw4;

import base.BaseSelenide;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.DatesPageSelenide;
import pageObjects.IndexPageSelenide;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.IndexPageEnum.*;

public class SelenideTestCase2 extends BaseSelenide {

    private IndexPageSelenide indexPageSelenide;
    private DatesPageSelenide datesPageSelenide;

    @BeforeMethod
    public void setPage() {
        indexPageSelenide = Selenide.page(IndexPageSelenide.class);
        datesPageSelenide = Selenide.page(DatesPageSelenide.class);
    }

    @AfterMethod
    public void closeBrowser() {
        WebDriverRunner.closeWebDriver();
    }

    @Test
    public void slidersTest() {

        //Open test site by URL
        indexPageSelenide.open(getWebDriver());

        //Assert title
        indexPageSelenide.checkPageTitle(getWebDriver().getTitle());

        //Perform login
        indexPageSelenide.login("epam","1234");

        //Assert User name in the left-top side of screen that user is loggined
        indexPageSelenide.checkUserName(USER_NAME.text);

        //Open through the header menu Service -> Dates
        indexPageSelenide.openDatesPage(getWebDriver());

        //Using drag-and-drop set Range sliders.
        //left sliders - the most left position, right slider - the most rigth position
        System.out.println("--------0-100");
        datesPageSelenide.setSliders(0, 100, getWebDriver());

        //Using drag-and-drop set Range sliders.
        //left sliders - the most left position, right slider - the most left position.
        System.out.println("--------0-0");
        datesPageSelenide.setSliders(0, 0, getWebDriver());

        //Using drag-and-drop set Range sliders.
        //left sliders - the most rigth position, right slider - the most rigth position.
        System.out.println("--------100-100");
        datesPageSelenide.setSliders(100, 100, getWebDriver());

        //Using drag-and-drop set Range sliders. 30 70
        System.out.println("--------30-70");
        datesPageSelenide.setSliders(30, 70, getWebDriver());
    }
}
