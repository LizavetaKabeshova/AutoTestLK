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

        // 2 Open test site by URL
        indexPageSelenide.open();

        // 3 Assert title
        indexPageSelenide.checkPageTitle(getWebDriver().getTitle());

        // 4 Perform login
        indexPageSelenide.login("epam","1234");

        // 5 Assert User name in the left-top side of screen that user is loggined
        indexPageSelenide.checkUserName(USER_NAME.text);

        // 6 Open through the header menu Service -> Dates
        datesPageSelenide.openDatesPage(getWebDriver());

        // 7 Using drag-and-drop set Range sliders.
        //left sliders - the most left position, right slider - the most rigth position
        datesPageSelenide.setSliders(0, 100);

        // 8 Using drag-and-drop set Range sliders.
        //left sliders - the most left position, right slider - the most left position.
        //datesPageSelenide.setSliders(0, 0);

        // 9 Using drag-and-drop set Range sliders.
        //left sliders - the most rigth position, right slider - the most rigth position.
        datesPageSelenide.setSliders(100, 100);

        // 10 Using drag-and-drop set Range sliders. 30 70
        //datesPageSelenide.setSliders(30, 70);
    }
}
