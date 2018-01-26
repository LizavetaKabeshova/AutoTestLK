package enums;

import java.util.ArrayList;
import java.util.List;

public enum DifferentElementsPageEnum {

    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire"),
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen"),
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");

    public String text;
    private static List<String> texts;

    DifferentElementsPageEnum(String text) {
        this.text = text;
    }

    public static List<String> getCheckBoxes() {
        texts = new ArrayList<String>();
        texts.add(WATER.text);
        texts.add(EARTH.text);
        texts.add(WIND.text);
        texts.add(FIRE.text);
        return texts;
    }




}
