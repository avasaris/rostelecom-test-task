package rostelecom.repository;

import rostelecom.model.ColorItem;

import java.util.List;

public interface Repository {
    List<ColorItem> getAllSorted();
}
