package siteJDI.pages;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.complex.ICheckList;
import com.epam.jdi.uitests.core.interfaces.complex.IComboBox;
import com.epam.jdi.uitests.core.interfaces.complex.IDropList;
import com.epam.jdi.uitests.core.interfaces.complex.IRadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.common.CheckBox;
import com.epam.jdi.uitests.web.selenium.elements.complex.*;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropList;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import siteJDI.enums.*;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

@JPage(url = "/metals-colors.html", title = "Metal and Colors")
public class MetalsColorsPage extends WebPage {

    @FindBy(css = "#odds-selector label")
    public RadioButtons oddsRadioButtons;

    @FindBy(css = "#even-selector label")
    public RadioButtons evenRadioButtons;

    @FindBy(css = "#elements-checklist label")
    public CheckList<ElementsEnum> elementsCheckBoxes;

    @FindBy(css = "#salad-dropdown li")
    public DropList<SaladEnum> saladDropDown;

    @FindBy(css = "#colors-dropdown li")
    public Dropdown<ColorsEnum> colorsDropDown;

    @JFindBy(css = "#metals-combobox li")
    public IComboBox<MetalsEnum> metalsComboBox;


    @Step
    public void fillDataMetalsColorsPage(SummaryEnum number1, SummaryEnum number2, ElementsEnum element1,
                                         ElementsEnum element2, ColorsEnum color1, MetalsEnum metal1,
                                         SaladEnum... saladEnums) {
        oddsRadioButtons.select(number1.text);
        evenRadioButtons.select(number2.text);
        elementsCheckBoxes.check(element1,element2);
        //metalsComboBox.select(metal1.text);
        //System.out.println(metalsComboBox().getValues());
        //Arrays.stream(saladEnums).forEachOrdered(s -> saladDropDown.check(s.text));




    }



}