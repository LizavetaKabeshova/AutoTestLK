package pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.actions;
import static org.testng.Assert.assertEquals;

public class DatesPageSelenide {

    @FindBy(css = ".ui-slider-handle:nth-of-type(1)")
    private SelenideElement leftSlider;

    @FindBy(css = ".ui-slider-handle:nth-of-type(2)")
    private SelenideElement rightSlider;

    @FindBy(css = ".dropdown-toggle")
    private SelenideElement buttonServiceTop;

    @FindBy(css = "[href='page4.htm']")
    private SelenideElement buttonDatesPage;

    @FindBy(css = "div.ui-slider-range.ui-widget-header.ui-corner-all")
    private SelenideElement sliderTrack;

    @Step
    public void openDatesPage(WebDriver driver) {
        buttonServiceTop.click();
        buttonDatesPage.click();
        assertEquals(driver.getCurrentUrl(), "https://jdi-framework.github.io/tests/page4.htm");
    }

    @Step
    public void setSliders(Integer left, Integer right) {
        actions().dragAndDropBy(leftSlider, -1000, 0).build().perform();
        actions().dragAndDropBy(rightSlider, 1000, 0).build().perform();

        setSliderPosition(left, leftSlider);
        setSliderPosition(right, rightSlider);

        assertEquals(getCurrentPosition(leftSlider), left);
        assertEquals(getCurrentPosition(rightSlider), right);
    }

    public double getStep() {
        double scrollPanelLength = rightSlider.getLocation().getX() - leftSlider.getLocation().getX();
        return scrollPanelLength / 100;
    }

    public Integer getCurrentPosition(SelenideElement slider) {
        return Integer.parseInt(slider.getText());
    }

    public void setSliderPosition(int position, SelenideElement slider) {
        int currentPosition = getCurrentPosition(slider);

        if (position != currentPosition) {
            double step = getStep();
            double xOffset = (position - currentPosition) * step;
            actions().dragAndDropBy(slider, (int) xOffset, 0).build().perform();
            }
    }
}