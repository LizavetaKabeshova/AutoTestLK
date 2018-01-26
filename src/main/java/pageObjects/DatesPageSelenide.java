package pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class DatesPageSelenide {

    @FindBy(css = "a.ui-slider-handle.ui-state-default.ui-corner-all")
    private List<SelenideElement> sliders;

    @Step
    public void setSliders(int left, int right, WebDriver driver) {
        Actions moveSlider = new Actions(driver);
        Action action = moveSlider.dragAndDropBy(sliders.get(0), left, 0).build();

        action.perform();

        System.out.println("slider 1 - " + sliders.get(0).getText());
        System.out.println("slider 1 - " + sliders.get(1).getText());
    }
}