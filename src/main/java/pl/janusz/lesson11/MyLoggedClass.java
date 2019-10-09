package pl.janusz.lesson11;

import java.util.logging.*;

/**
 * Created by Janusz Kacki on 09/10/2019. Project; bielmarcus
 */
public class MyLoggedClass {

    private final static Logger LOGGER = Logger.getLogger(MyLoggedClass.class.getName());
    static {
        prepareLogger();
    }

    private static void prepareLogger() {
        LOGGER.setLevel(Level.INFO);
        Handler handler = new ConsoleHandler();
        Formatter formatter = new SimpleFormatter();
        LOGGER.addHandler(handler);
        handler.setFormatter(formatter);
        LOGGER.setUseParentHandlers(false);
    }

    public static void main(String[] args) {
        LOGGER.info("Logger ready");
        System.out.println("Hello");
        LOGGER.info("Done");
    }
}
