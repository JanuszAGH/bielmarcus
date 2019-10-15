package pl.janusz.lesson20;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 15/10/2019. Project; bielmarcus
 */
//@RunWith(Parameterized.class)
public class XORTest {

    @Test
    public void shouldDo0XOR0() {

        int a = 10;
        int b = 7;
        int result = a ^ b;

        assertThat(result, is(equalTo(13)));
        assertThat(Integer.toBinaryString(a), is(equalTo("1010")));
        assertThat(Integer.toBinaryString(b), is(equalTo("111")));
        assertThat(Integer.toBinaryString(result), is(equalTo("1101")));
    }
}