package pl.janusz.lesson19;

import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class BigNumbersDemoTest {

    @Test
    public void test_BigNumbersDemoTest() throws Exception {

        BigInteger ten = BigInteger.valueOf(10);
        BigInteger five = new BigInteger("5");
        BigInteger sum = ten.add(five);
        BigInteger difference = ten.subtract(five);
        BigInteger product = ten.multiply(five);
        BigInteger quotient = ten.divide(five);

        assertThat(sum, is(equalTo(new BigInteger("15"))));
        assertThat(difference, is(equalTo(BigInteger.valueOf(5))));
        assertThat(product.intValue(), is(equalTo(50)));
        assertThat(quotient.toString(), is(equalTo("2")));
    }
}