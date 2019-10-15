package pl.janusz.lesson20;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 15/10/2019. Project; bielmarcus
 */
public class XORMirroringTest {

    @Test
    public void shouldReverseBasicCases() {

        assertThat(XOR.mirrorBinaryNumber(null), is(equalTo(null)));
        assertThat(XOR.mirrorBinaryNumber(""), is(equalTo("")));
        assertThat(XOR.mirrorBinaryNumber("0"), is(equalTo("0")));
        assertThat(XOR.mirrorBinaryNumber("1"), is(equalTo("1")));
        assertThat(XOR.mirrorBinaryNumber("00"), is(equalTo("00")));
        assertThat(XOR.mirrorBinaryNumber("11"), is(equalTo("11")));
        assertThat(XOR.mirrorBinaryNumber("01"), is(equalTo("10")));
        assertThat(XOR.mirrorBinaryNumber("10"), is(equalTo("01")));
        assertThat(XOR.mirrorBinaryNumber("10110001101"), is(equalTo("10110001101")));
    }
}