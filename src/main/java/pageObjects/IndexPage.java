package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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

    public IndexPage() {
    }

    public void login(String name, String password) {
        loginFormButton.click();
        loginInput.sendKeys(name);
        passordInput.sendKeys(password);
        submitButton.click();
    }


    @FindBy(css = ".icons-benefit")
    private List<WebElement> imgElements;

    public void checkIcons(String s) {
        for (WebElement imgElement : imgElements) {
            assertTrue(imgElement.isDisplayed());
            assertEquals(imgElement.getCssValue("background-image"), s);
        }
    }

    @FindBy(css = ".benefit-txt")
    private List<WebElement> textBoxes;

    public void checkTexts(List<String> texts) {
        for (int i = 0; i < textBoxes.size(); i++) {
            assertTrue(textBoxes.get(i).isDisplayed());
            assertEquals(textBoxes.get(i).getText().replaceAll("\\n", " "), texts.get(i));
        }
    }

    @FindBy(css = ".main-title")
    private WebElement mainTitle;

    public void checkMainTitle(String s) {
        assertTrue(mainTitle.isDisplayed());
        assertEquals(mainTitle.getText(), s);
    }

    @FindBy(css = ".main-txt")
    private WebElement mainText;

    public void checkMainText(String s) {
        assertTrue(mainText.isDisplayed());
        assertEquals(mainText.getText().replaceAll("\\n", " "), s);
    }

    public void checkTitle(WebDriver driver) {
        assertEquals(driver.getTitle(), TITLE.text);
    }

    @FindBy(css=".profile-photo>span")
    private WebElement userName;

    public void checkUser (String s) {
        assertTrue(userName.isDisplayed());
        assertEquals(userName.getText(), s);
    }
}

