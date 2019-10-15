package pl.janusz.lesson20;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 15/10/2019. Project; bielmarcus
 */
@RunWith(Parameterized.class)
public class XORParameterizedTest {

    @Parameterized.Parameter(value = 0)
    public int a;
    @Parameterized.Parameter(value = 1)
    public int b;
    @Parameterized.Parameter(value = 2)
    public int xor;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][]{
                {0, 0, 0},
                {0, 1, 1},
                {1, 0, 1},
                {0, 0, 0}
        });
    }

    @Test
    public void shouldDoXOR() {

        int result = a ^ b;
        assertThat(result, is(equalTo(xor)));
    }
}