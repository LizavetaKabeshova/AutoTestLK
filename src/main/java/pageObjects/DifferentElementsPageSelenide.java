package pageObjects;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

import static enums.IndexPageEnum.TITLE;
import static org.testng.Assert.assertEquals;

public class DifferentElementsPageSelenide {

    @Step
    public void open(WebDriver driver) {
        driver.navigate().to("https://jdi-framework.github.io/tests/page8.htm");
    }

    @Step
    public void checkPageTitle(WebDriver driver) {
        assertEquals(driver.getTitle(), TITLE.text);
        assertEquals(driver.getCurrentUrl(), "https://jdi-framework.github.io/tests/page8.htm");
    }
}
