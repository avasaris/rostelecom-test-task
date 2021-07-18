package rostelecom;

import com.google.gson.Gson;
import rostelecom.model.ColorItem;
import rostelecom.repository.ColorRepository;
import rostelecom.service.Config;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ColorRepository colorRepository = Config.get().getColorRepository();

        List<ColorItem> items = colorRepository.getAllSorted();

        System.out.println(items);

        Gson gson = new Gson();
        String jsonItems = gson.toJson(items);
        System.out.println("jsonItems = " + jsonItems);
    }
}
