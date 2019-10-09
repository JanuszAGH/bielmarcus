package pl.janusz.lesson12;

import java.util.Random;

/**
 * Created by Janusz Kacki on 09/10/2019. Project; bielmarcus
 */
public class OneExceptions {

    public static void main(String[] args) {

        new OneExceptions().start();
    }

    private void start() {

        try {
            riskyMethod();
        } catch (Exception e) {
            System.out.println("Begin of catch");
            if (new Random().nextBoolean()) {
                throw new RuntimeException();
            }
            System.out.println(e.getMessage());
            System.out.println("End of catch");
        } finally {
            System.out.println("Begin of finally");
            if (new Random().nextBoolean()) {
                throw new RuntimeException();
            }
            System.out.println("End of finally");
        }
    }

    private void riskyMethod() throws Exception {

        if (new Random().nextBoolean()) {
            System.out.println("Shit has happened");
            throw new Exception("From riskyMethod");
        }
    }
}
