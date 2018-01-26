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
import static enums.DifferentElementsPageEnum.*;
import static enums.IndexPageEnum.*;

public class SelenideTestCase1 extends BaseSelenide {

    private IndexPageSelenide indexPageSelenide;
    private DifferentElementsPageSelenide differentElementsPageSelenide;

    @BeforeMethod
    public void setPage() {
        indexPageSelenide = Selenide.page(IndexPageSelenide.class);
        differentElementsPageSelenide = Selenide.page(DifferentElementsPageSelenide.class);
    }

    @AfterMethod
    public void closeBrowser() {
        WebDriverRunner.closeWebDriver();
    }

    @Test
    public void differentElementsTest() {

        //Open test site by URL
        indexPageSelenide.open(getWebDriver());

        //Assert title
        indexPageSelenide.checkPageTitle(getWebDriver().getTitle());

        //Perform login
        indexPageSelenide.login("epam","1234");

        //Assert User name in the left-top side of screen that user is loggined
        indexPageSelenide.checkUserName(USER_NAME.text);

        //Check interface on Home page, it contains all needed elements.
        indexPageSelenide.checkInterfaceIndexPage(getTexts(), TEXT_TITLE.text, TEXT_CONTENT.text);

        //Click on "Service" subcategory in the header and check that drop down contains options
        indexPageSelenide.checkButtonServiceTop(getTextsServiceTop());

        //Click on Service subcategory in the left section and check that drop down contains options
        indexPageSelenide.checkButtonServiceLeft(getTextsServiceTop());

        //Open through the header menu Service -> Different Elements Page
        indexPageSelenide.openDifferentElementsPage(getWebDriver());

        //Check interface on Service page, it contains all needed elements.
        differentElementsPageSelenide.checkInterfaceDifferentElements();

        //Select and assert checkboxes Water, Wind
        differentElementsPageSelenide.selectCheckBoxes(WATER, WIND);

        //Select radio Selen
        differentElementsPageSelenide.selectRadio(SELEN);

        //Select in dropdown Yellow
        differentElementsPageSelenide.selectDropDown(YELLOW.text);

        //Check in logs section selected values and status (true|false) Water, Wind, Selen, Yellow
        differentElementsPageSelenide.checkLogs(1, WATER, WIND, SELEN, YELLOW);

        //Unselect and assert checkboxes Water, Wind
        differentElementsPageSelenide.unselectCheckBoxes(WATER, WIND);

        //Check in logs section unselected values and status (true|false)
        differentElementsPageSelenide.checkLogs(0, WATER, WIND);
    }
}
