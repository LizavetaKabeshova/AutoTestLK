package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

import static enums.IndexPageEnum.TITLE;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class IndexPage {

    @FindBy(css = ".uui-profile-menu .dropdown-toggle")
    private WebElement loginFormButton;

    @FindBy(css = "#Login")
    private WebElement loginInput;

    @FindBy(css = "#Password")
    private WebElement passordInput;

    @FindBy(css = ".form-horizontal [type='submit']")
    private WebElement submitButton;

    @FindBy(css = ".icons-benefit")
    private List<WebElement> imgElements;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> textBoxes;

    @FindBy(css = ".main-title")
    private WebElement mainTitle;

    @FindBy(css = ".main-txt")
    private WebElement mainText;

    @FindBy(css=".profile-photo>span")
    private WebElement userName;

    public void login(String name, String password) {
        loginFormButton.click();
        loginInput.sendKeys(name);
        passordInput.sendKeys(password);
        submitButton.click();
    }

    public void checkIcons() {
        imgElements.stream().map(WebElement::isDisplayed).forEach(Assert::assertTrue);
    }

    public void checkTexts(List<String> texts) {
        textBoxes.stream().map(WebElement::isDisplayed).forEach(Assert::assertTrue);
        for (int i = 0; i < 4; i++) {
           assertEquals(textBoxes.get(i).getText().replaceAll("\\n", " "), texts.get(i));
        }
    }

    public void checkMainTitle(String s) {
        assertTrue(mainTitle.isDisplayed());
        assertEquals(mainTitle.getText(), s);
    }

    public void checkMainText(String s) {
        assertTrue(mainText.isDisplayed());
        assertEquals(mainText.getText().replaceAll("\\n", " "), s);
    }

    public void checkTitle(WebDriver driver) {
        assertEquals(driver.getTitle(), TITLE.text);
    }

    public void checkUser (String s) {
        assertTrue(userName.isDisplayed());
        assertEquals(userName.getText(), s);
    }
}

