package pl.janusz.mocking.car;

/**
 * Created by Janusz Kacki on 08/10/2019. Project; bielmarcus
 */
public interface Car {

    boolean needsFuel();

    double getEngineTemperature();

    void driveTo(String destination);
}
