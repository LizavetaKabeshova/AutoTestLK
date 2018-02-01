package siteJDI.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;

import siteJDI.entities.User;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends Form<User> {
    @FindBy(id="Login") public TextField name;
    @FindBy(id="Password") public TextField password;

    @Css("[type=submit]") public Button enter;
}
