package pl.janusz.lesson12;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 09/10/2019. Project; bielmarcus
 */
@RunWith(Parameterized.class)
public class CarStateTest {

    @Parameterized.Parameter(value = 0)
    public String stateString;
    @Parameterized.Parameter(value = 1)
    public CarState carState;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][]{
                {"driving", CarState.DRIVING},
                {"DRIVING", CarState.DRIVING},
                {"waiting", CarState.WAITING},
                {"WAITING", CarState.WAITING},
                {"parking", CarState.PARKING},
                {"PARKING", CarState.PARKING}
        });
    }

    @Test
    public void shouldReturnCarState() throws Exception {

        CarState stateFrom = CarState.from(stateString);
        assertThat(stateFrom, is(carState));
    }
}