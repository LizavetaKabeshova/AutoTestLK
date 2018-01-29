package pageObjects;

import com.codeborne.selenide.SelenideElement;
import enums.DifferentElementsPageEnum;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;
import java.util.stream.IntStream;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static org.testng.Assert.assertEquals;

public class DifferentElementsPageSelenide {

    @FindBy(css = ".label-checkbox")
    private List<SelenideElement> checkBoxes;

    @FindBy(css = ".label-radio")
    private List<SelenideElement> labelRadioButtons;

    @FindBy(css = "select.uui-form-element")
    private SelenideElement dropDown;

    @FindBy(css = ".uui-button")
    private List<SelenideElement> buttons;

    @FindBy(css = ".mCSB_container")
    private SelenideElement leftSection;

    @FindBy(css = "._mCS_2")
    private SelenideElement rightSection;

    @FindBy(css = "ul.panel-body-list.logs")
    private SelenideElement logs;

    @FindBy(css = ".dropdown-toggle")
    private SelenideElement buttonServiceTop;

    @FindBy(css = "[href='page8.htm']")
    private SelenideElement buttonDifferentElementsPage;

    private SelenideElement elementName;

    @Step
    public void checkInterfaceDifferentElements() {
        IntStream.range(0, 4).forEach(i -> checkBoxes.get(i).should(exist));
        IntStream.range(0, 4).forEach(i -> labelRadioButtons.get(i).should(exist));
        dropDown.should(exist);
        IntStream.range(0, 2).forEach(i -> buttons.get(i).should(exist));
        leftSection.should(exist);
        rightSection.should(exist);
    }

    @Step
    public void openDifferentElementsPage(WebDriver driver) {
        buttonServiceTop.click();
        buttonDifferentElementsPage.click();
        assertEquals(driver.getCurrentUrl(), "https://jdi-framework.github.io/tests/page8.htm");
    }

    private SelenideElement selectCheckBox(DifferentElementsPageEnum elementEnum) {
        for (SelenideElement checkBoxe : checkBoxes) {
            if (checkBoxe.getText().equals(elementEnum.text)) {
                elementName = checkBoxe;
            }
        }
        return elementName;
    }

    private SelenideElement selectRad(DifferentElementsPageEnum elementEnum) {
        for (SelenideElement labelRadioButton : labelRadioButtons) {
            if (labelRadioButton.getText().equals(elementEnum.text)) {
                elementName = labelRadioButton;
            }
        }
        return elementName;
    }

    @Step
    public void selectCheckBoxes(DifferentElementsPageEnum... enumElements) {
        for (DifferentElementsPageEnum enumElement : enumElements) {
            selectCheckBox(enumElement).click();
            selectCheckBox(enumElement).find("Input").should(checked);
        }
    }

    @Step
    public void selectRadio(DifferentElementsPageEnum... enumElements) {
        for (DifferentElementsPageEnum enumElement : enumElements) {
            selectRad(enumElement).click();
            selectRad(enumElement).find("Input").should(checked);
        }
    }

    @Step
    public void selectDropDown(String s) {
        dropDown.click();
        dropDown.selectOption(s);
        dropDown.shouldHave(text(s));
    }

    @Step
    public void checkLogs(int k, DifferentElementsPageEnum... enumElements) {
        int r = 0;
        for (DifferentElementsPageEnum enumElement : enumElements) {
            logs.shouldHave(text(enumElement.text));
        }
        if (StringUtils.countMatches(logs.getText(), "true") >
                StringUtils.countMatches(logs.getText(), "false")) {
            r = 1;
        }
        assertEquals(r, k);
    }

    @Step
    public void unselectCheckBoxes(DifferentElementsPageEnum... enumElements) {
        for (DifferentElementsPageEnum enumElement : enumElements) {
            selectCheckBox(enumElement).click();
            selectCheckBox(enumElement).find("Input").shouldNotBe(checked);
        }
    }
}
