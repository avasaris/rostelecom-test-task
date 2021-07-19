package rostelecom.utils;

import rostelecom.model.ColorItem;

import java.util.List;

public class StaticCollection {
    public static void init(List<ColorItem> items) {

        items.add(new ColorItem("01", "Red"));
        items.add(new ColorItem("02", "Orange"));
        items.add(new ColorItem("03", "Yellow"));
        items.add(new ColorItem("04", "Green"));
        items.add(new ColorItem("05", "Blue"));
        items.add(new ColorItem("06", "Dark blue"));
        items.add(new ColorItem("07", "Violet"));

    }
}
