package pl.janusz.lesson20;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 15/10/2019. Project; bielmarcus
 */
public class SBTest {

    @Test
    public void shouldConcatenat() {

        String alice = "Alice";
        String in = "in";
        String wonderland = "Wonderland";
        String expected = alice + in + wonderland;

        StringBuilder stringBuilder = new StringBuilder();
        String text = stringBuilder
                .append(alice)
                .append(in)
                .append(wonderland)
                .toString();

        assertThat(text, is(equalTo(expected)));
    }
}