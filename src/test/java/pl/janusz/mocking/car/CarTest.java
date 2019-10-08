package pl.janusz.mocking.car;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import pl.janusz.mocking.car.Car;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 08/10/2019. Project; bielmarcus
 */
public class CarTest {

    private Car cadillac;
    private String home;

    @Test
    public void sholdDriveMeHome() {

        cadillac.needsFuel();
        cadillac.driveTo(home);
        cadillac.needsFuel();

        Mockito
                .verify(cadillac, Mockito.times(2))
                .needsFuel();

        Mockito
                .verify(cadillac, Mockito.times(1))
                .driveTo(Mockito.anyString());
    }

    @Before
    public void setUp() throws Exception {

        this.home = "Sweet Home Alabama";
        cadillac = Mockito
                .mock(Car.class);

        Mockito
                .when(cadillac.needsFuel())
                .thenReturn(true);

        Mockito
                .when(cadillac.getEngineTemperature())
                .thenReturn(10.0);
    }

    @Test
    public void shouldNeedFuel() {

        assertThat(cadillac.needsFuel(), is(true));
    }

    @Test
    public void engineShouldBeCold() {

        assertThat(cadillac.getEngineTemperature(), is(equalTo(10.0)));
    }

    @Test
    public void shouldBeACar() {

        assertThat(cadillac instanceof Car, is(true));
    }
}