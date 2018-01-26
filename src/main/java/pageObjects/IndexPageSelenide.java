package pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static enums.IndexPageEnum.TITLE;
import static org.testng.Assert.assertEquals;

public class IndexPageSelenide {

    @FindBy(css = ".uui-profile-menu .dropdown-toggle")
    private SelenideElement loginFormButton;

    @FindBy(css = "#Login")
    private SelenideElement loginInput;

    @FindBy(css = "#Password")
    private SelenideElement passordInput;

    @FindBy(css = ".form-horizontal [type='submit']")
    private SelenideElement submitButton;

    @FindBy(css = ".profile-photo>span")
    private SelenideElement userName;

    @FindBy(css = ".icons-benefit")
    private List<SelenideElement> imgElements;

    @FindBy(css = ".benefit-txt")
    private List<SelenideElement> textBoxes;

    @FindBy(css = ".main-title")
    private SelenideElement mainTitle;

    @FindBy(css = ".main-txt")
    private SelenideElement mainText;

    @FindBy(css = ".dropdown-toggle")
    private SelenideElement buttonServiceTop;

    @FindBy(css = ".dropdown-menu>li")
    private List<SelenideElement> elementsServiceTop;

    @FindBy(css = ".sub-menu")
    private SelenideElement buttonServiceLeft;

    @FindBy(css = ".sub-menu>li")
    private List<SelenideElement> elementsServiceLeft;

    @FindBy(css = "[href='page8.htm']")
    private SelenideElement buttonDifferentElementsPage;

    @FindBy(css = "[href='page4.htm']")
    private SelenideElement buttonDatesPage;

    @Step
    public void open(WebDriver driver) {
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
    }

    @Step
    public void login(String name, String password) {
        loginFormButton.should(visible);
        loginFormButton.click();
        loginInput.sendKeys(name);
        passordInput.sendKeys(password);
        submitButton.click();
    }

    @Step
    public void checkPageTitle(String s) {
        assertEquals(s, TITLE.text);
    }

    @Step
    public void checkUserName(String s) {
        userName.should(visible);
        userName.shouldHave(text(s));
    }

    @Step
    public void checkButtonServiceTop(List<String> texts) {
        buttonServiceTop.click();
        elementsServiceTop.forEach((list -> list.should(exist)));
        for (int i = 0; i < elementsServiceTop.size(); i++) {
            assertEquals(elementsServiceTop.get(i).getText().replaceAll("\\n", " "), texts.get(i));
        }
    }

    @Step
    public void checkButtonServiceLeft(List<String> texts) {
        buttonServiceLeft.click();
        elementsServiceLeft.forEach((list -> list.should(exist)));
        for (int i = 0; i < elementsServiceLeft.size(); i++) {
            assertEquals(elementsServiceLeft.get(i).getText().replaceAll("\\n", " "), texts.get(i));
        }
    }

    @Step
    public void openDifferentElementsPage(WebDriver driver) {
        buttonServiceTop.click();
        buttonDifferentElementsPage.click();
        assertEquals(driver.getCurrentUrl(), "https://jdi-framework.github.io/tests/page8.htm");
    }

    @Step
    public void checkInterfaceIndexPage(List<String> texts, String text, String text1) {
        imgElements.forEach((list -> list.should(exist)));
        textBoxes.forEach((list -> list.should(exist)));
        for (int i = 0; i < textBoxes.size(); i++) {
            assertEquals(textBoxes.get(i).getText().replaceAll("\\n", " "), texts.get(i));
        }
        mainTitle.should(exist);
        mainTitle.shouldHave(text(text));
        mainTitle.should(exist);
        mainText.shouldHave(text(text1));
    }

    @Step
    public void openDatesPage(WebDriver driver) {
        buttonServiceTop.click();
        buttonDatesPage.click();
        assertEquals(driver.getCurrentUrl(), "https://jdi-framework.github.io/tests/page4.htm");
    }
}