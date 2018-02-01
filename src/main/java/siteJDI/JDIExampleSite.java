package siteJDI;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;

import siteJDI.entities.User;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import siteJDI.pages.HomePage;
import siteJDI.pages.MetalsColorsPage;
import siteJDI.sections.LoginForm;

@JSite("https://epam.github.io/JDI/")
public class JDIExampleSite extends WebSite {

    public static HomePage homePage;
    public static LoginForm loginForm;
    public static MetalsColorsPage metalsColorsPage;

    @FindBy(css = ".profile-photo")
    public static Label profilePhoto;

    @FindBy(css = "[href='metals-colors.html']")
    public static Button metalsColorsButton;

    @Step
    public static void login() {
        profilePhoto.click();
        loginForm.loginAs(new User());
    }
}
