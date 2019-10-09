package pl.janusz.lesson12;

import org.junit.Test;
import org.mockito.Mockito;
import pl.janusz.mocking.car.Car;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 09/10/2019. Project; bielmarcus
 */
public class CarStateSingleTest {

    @Test
    public void shouldReturnCarStateParking() throws Exception {

        CarState parking = CarState.from("PARKING");
        assertThat(parking, is(CarState.PARKING));
    }

    @Test
    public void shouldReturnCarStateWaiting() throws Exception {

        CarState waiting = CarState.from("WaItInG");
        assertThat(waiting, is(equalTo(CarState.WAITING)));
    }

    @Test
    public void shouldReturnCarStateDriving() throws Exception {

        CarState driving = CarState.from("driving");
        assertThat(driving, is(CarState.DRIVING));
    }

    @Test
    public void shouldThrowExceptionWhenWrongStateToParse() {

            String stateName = "badState";
        try {
            CarState badState = CarState.from(stateName);
            fail();
        } catch (Exception e) {
            assertThat(e.getMessage(), is(equalTo("Unknown state: " + stateName)));
        }
    }
}