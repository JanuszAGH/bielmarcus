package pl.janusz.lesson11;

import java.util.logging.Logger;

/**
 * Created by Janusz Kacki on 09/10/2019. Project; bielmarcus
 */
public class AnotherLogger {

    public static final Logger LOGGER = Logger.getLogger(AnotherLogger.class.getName());

    static {
        prepareLogger();
    }

    private static void prepareLogger() {
        

    }
}
