package enums;

import java.util.ArrayList;
import java.util.List;

public enum IndexPageTextBoxesEnum {

    TEXT_1("To include good practices and ideas from successful EPAM projec"),
    TEXT_2("To be flexible and customizable"),
    TEXT_3("To be multiplatform"),
    TEXT_4("Already have good base (about 20 internal and some external projects), wish to get more…");

    public String text;
    private static List<String> texts;

    IndexPageTextBoxesEnum(String text) {
        this.text = text;
    }

    public static List<String> getTexts() {
        texts = new ArrayList<String>();
        texts.add(TEXT_1.text);
        texts.add(TEXT_2.text);
        texts.add(TEXT_3.text);
        texts.add(TEXT_4.text);
        return texts;
    }
}

