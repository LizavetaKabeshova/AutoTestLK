package hw4;

import base.BaseSelenide;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.DifferentElementsPageSelenide;
import pageObjects.IndexPageSelenide;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.IndexPageEnum.*;

public class SelenideTest extends BaseSelenide {

    private IndexPageSelenide indexPageSelenide;
    private DifferentElementsPageSelenide differentElementsPageSelenide;

    @BeforeMethod
    public void setPage() {
        indexPageSelenide = Selenide.page(IndexPageSelenide.class);
    }

    @AfterMethod
    public void closeBrowser() {
        WebDriverRunner.closeWebDriver();
    }

    @Test
    public void loginTest() {

        //Open test site by URL
        indexPageSelenide.open(getWebDriver());
/*
        //Assert title
        indexPageSelenide.checkPageTitle(getWebDriver().getTitle());

        //Perform login
        indexPageSelenide.login("epam","1234");

        //Assert User name in the left-top side of screen that user is loggined
        indexPageSelenide.checkUserName(USER_NAME.text);

        //Check interface on Home page, it contains all needed elements.
        indexPageSelenide.checkImages();
        indexPageSelenide.checkTexts(getTexts());
        indexPageSelenide.checkMainTitle(TEXT_TITLE.text);
        indexPageSelenide.checkMainText(TEXT_CONTENT.text);
*/
        //Click on "Service" subcategory in the header and check that drop down contains options
        indexPageSelenide.checkButtonServiceTop(getTextsServiceTop());

        //Click on Service subcategory in the left section and check that drop down contains options
        indexPageSelenide.checkButtonServiceLeft(getTextsServiceTop());

        //Open through the header menu Service -> Different Elements Page
        indexPageSelenide.openDifferentElementsPage(getWebDriver());

        //Check interface on Service page, it contains all needed elements.
        //differentElementsPageSelenide.checkPageTitle(getWebDriver());
        differentElementsPageSelenide.open(getWebDriver());

        //Select and assert checkboxes
        //Select radio
        //Select in dropdown
        //Check in logs section selected values and status (true|false)
        //Unselect and assert checkboxes
        //Check in logs section unselected values and status (true|false)

    }



}
