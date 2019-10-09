package pl.janusz.lesson11;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

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