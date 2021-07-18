package rostelecom.service;

import rostelecom.repository.ColorRepository;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final String PROPS = "/rostelecom.properties";
    private static final Config INSTANCE = new Config();

    private final ColorRepository colorRepository;

    private Config() {
        try (InputStream is = Config.class.getResourceAsStream(PROPS)) {
            Properties props = new Properties();
            props.load(is);
            colorRepository = new ColorRepository(props.getProperty("db.url"), props.getProperty("db.user"), props.getProperty("db.password"));
        } catch (IOException e) {
            throw new IllegalStateException("Invalid config file " + PROPS);
        }
    }

    public static Config get() {
        return INSTANCE;
    }

    public ColorRepository getColorRepository() {
        return colorRepository;
    }
}