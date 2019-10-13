package pl.janusz.lesson18;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Janusz Kacki on 13/10/2019. Project; bielmarcus
 */
public class FirstTryCatch {

    public static void main(String[] args) {

        new FirstTryCatch().start();
    }

    private void start() {

        riskyMethod();
    }

    private void riskyMethod() {

        try {
            System.out.println("Begin of try");
            if (ThreadLocalRandom.current().nextBoolean()) {
                throw new RuntimeException("Shit happens");
            }
            System.out.println("End of try");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Begin of finally");
            int quotient = 4 / ThreadLocalRandom.current().nextInt(2);
            System.out.println("End of finally");
        }
    }
}
