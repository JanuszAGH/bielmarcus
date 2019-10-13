package pl.janusz.lesson18;

import java.util.ArrayList;

/**
 * Created by Janusz Kacki on 13/10/2019. Project; bielmarcus
 */
public class FinallyDeadMain {

    public static void main(String[] args) throws Throwable {

        ArrayList<Object> finallyDeads = new ArrayList<>();
        FinallyDead finallyDead = new FinallyDead();
        finallyDeads.add(finallyDead);
        finallyDead.finalize();

        System.out.println("Before gc");
//        System.gc();
        System.out.println("After gc");
    }
}
