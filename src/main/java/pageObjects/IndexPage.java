package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class IndexPage {

        @FindBy(css = ".uui-profile-menu .dropdown-toggle")
        private WebElement loginFormButton;

        @FindBy(css = "#Login")
        private WebElement loginInput;

        @FindBy(css = "#Password")
        private WebElement passordInput;

        @FindBy(css = ".form-horizontal [type='submit']")
        private WebElement submitButton;

        public void login(String name, String password) {
            loginFormButton.click();
            loginInput.sendKeys(name);
            passordInput.sendKeys(password);
            submitButton.click();
        }


        @FindBy(css = ".icons-benefit")
        private List<WebElement> imgElements;
        public void icons(String s) {
            for (int i = 0; i < imgElements.size(); i++) {
                Assert.assertTrue(imgElements.get(i).isDisplayed());
                Assert.assertEquals(imgElements.get(i).getCssValue("background-image"), s);
            }
        }

        @FindBy(css = ".benefit-txt")
        private List<WebElement> textBoxes;
        public void texts(String t[]) {
            for (int i = 0; i < textBoxes.size(); i++) {
                Assert.assertTrue(textBoxes.get(i).isDisplayed());
                Assert.assertEquals(textBoxes.get(i).getText().replaceAll("\\n"," "), t[i]);
        }
    }

        @FindBy(css = ".main-title")
        private WebElement mainTitle;
        public void checkMainTitle(String s){
            Assert.assertTrue(mainTitle.isDisplayed());
            Assert.assertEquals(mainTitle.getText(),s);
        }

        @FindBy(css = ".main-txt")
        private WebElement mainTxt;
        public void checkMainTxt(String s){
            Assert.assertTrue(mainTxt.isDisplayed());
            Assert.assertEquals(mainTxt.getText().replaceAll("\\n"," "),s);
        }

}

