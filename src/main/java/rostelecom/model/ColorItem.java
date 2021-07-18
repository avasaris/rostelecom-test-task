package rostelecom.model;

import java.io.Serializable;

public class ColorItem implements Serializable {

    private final String number;
    private final String name;

    public ColorItem(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
