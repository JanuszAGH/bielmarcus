package pl.janusz.lesson18;

/**
 * Created by Janusz Kacki on 13/10/2019. Project; bielmarcus
 */
public class FinallyDead {

    @Override
    protected void finalize() throws Throwable {

        super.finalize();

        System.out.println("I'm dying");
    }
}
