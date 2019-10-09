package pl.janusz.lesson11;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.*;

/**
 * Created by Janusz Kacki on 09/10/2019. Project; bielmarcus
 */
public class LoginExamples {

    private final static Logger LOGGER = Logger.getLogger(LoginExamples.class.getName());

    public static void main(String[] args) {

        LOGGER.setLevel(Level.ALL);
        Handler handler = new ConsoleHandler();
        Formatter formatter = new SimpleFormatter();
        handler.setFormatter(formatter);
        LOGGER.addHandler(handler);
        LOGGER.setUseParentHandlers(false);

        new LoginExamples().start();
    }

    private void start() {

        doIt();
    }

    public void doIt() {

        LOGGER.entering(this.getClass().getName(), "doIt");

        try {
            int denominator = ThreadLocalRandom.current().nextInt(2);
            int nominator = 10;
            int riskyDivisioen = nominator / denominator;
        } catch (ArithmeticException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }

        LOGGER.exiting(this.getClass().getName(), "doIt");
    }
}
