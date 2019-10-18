package pl.janusz.biel.lesson11;

import org.junit.Test;

/**
 * Created by Janusz Kacki on 09/10/2019. Project; bielmarcus
 */
public class CarServiceTest {

    @Test
    public void shouldDemonstrateLogging() {

        CarService carService = new CarService();
        carService.process("BMW");
    }
}