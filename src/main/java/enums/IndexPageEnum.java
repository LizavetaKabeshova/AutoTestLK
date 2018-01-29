package enums;

import java.util.ArrayList;
import java.util.List;

public enum IndexPageEnum {

    TITLE("Index Page"),
    USER_NAME("PITER CHAILOVSKII"),
    TEXT_TITLE("EPAM FRAMEWORK WISHES…"),
    TEXT_CONTENT("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD " +
            "TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD " +
            "EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR " +
            "IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR."),
    BUTTON_SERVICE_1("SUPPORT"),
    BUTTON_SERVICE_2("DATES"),
    BUTTON_SERVICE_3("COMPLEX TABLE"),
    BUTTON_SERVICE_4("SIMPLE TABLE"),
    BUTTON_SERVICE_5("TABLE WITH PAGES"),
    BUTTON_SERVICE_6("DIFFERENT ELEMENTS");

    public String text;
    private static List<String> texts;

    IndexPageEnum(String text) {
        this.text = text;
    }

    public static List<String> getTextsServiceTop() {
        texts = new ArrayList<String>();
        texts.add(BUTTON_SERVICE_1.text);
        texts.add(BUTTON_SERVICE_2.text);
        texts.add(BUTTON_SERVICE_3.text);
        texts.add(BUTTON_SERVICE_4.text);
        texts.add(BUTTON_SERVICE_5.text);
        texts.add(BUTTON_SERVICE_6.text);
        return texts;
    }
}
