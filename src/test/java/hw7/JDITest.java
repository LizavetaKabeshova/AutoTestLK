package hw7;

import org.testng.annotations.Test;

import static siteJDI.JDIExampleSite.*;

import static siteJDI.enums.ElementsEnum.*;
import static siteJDI.enums.SummaryEnum.*;
import static siteJDI.enums.ColorsEnum.*;
import static siteJDI.enums.MetalsEnum.*;
import static siteJDI.enums.SaladEnum.*;

public class JDITest extends SimpleTestInit {

        @Test
    public void loginTest() {
        // 1 Login on JDI site as UseR
        homePage.open();
        login();
        homePage.checkOpened();

        // 2 Open Metals & Colors page by Header menu
        metalsColorsPage.open();
        //openMetalsColorsPageByHeaderMenu();
        metalsColorsPage.checkOpened();

        // 3 Fill form Metals & Colors by data below:
        // Submit form Metals & Colors
        metalsColorsPage.fillDataMetalsColorsPage(THREE, EIGHT, WATER, FIRE, RED, SELEN,CUCUMBER,TOMATO);


    // 4 Result sections should contains data  below:
    }
}
