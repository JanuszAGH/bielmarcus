package pl.janusz.greencroft.isbntools;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 17/10/2019. Project; bielmarcus
 */
public class ValidateISBNTest {

    private ValidateISBN validator;

    @Before
    public void setUp() throws Exception {

        validator = new ValidateISBN();
    }

    @Test
    public void shouldCheckAnotherValidISBN() {

        String validISBN = "0140177396";

        boolean result = validator.checkISBN(validISBN);

        assertThat("0140177396 should be validated", result, is(true));
    }

    @Test
    public void shouldCheckValidISBN() {

        String validISBN = "0306406152";
        boolean result = validator.checkISBN(validISBN);

        assertThat("01404491116 shoould be validated", result, is(true));
    }

    @Test
    public void shouldNotPassInvalidISBNNumber() {

        String invalidISBN = "1234567890";
        boolean result = validator.checkISBN(invalidISBN);

        assertThat("01404491117 should'nt be validated", result, is(false));
    }

    @Test
    public void shouldNotValidateNon10digitsISBNsAndThrowExceptions() {

        String invalidISBN = "123456789";

        try {
            boolean result = validator.checkISBN(invalidISBN);
            fail();
        } catch (Exception e) {
            assertThat(e, instanceOf(NumberFormatException.class));
        }
    }

    @Test
    public void shouldValidateWihXOnTheLastPosition() {

        String validISBN = "012000030X";

        boolean result = validator.checkISBN(validISBN);

        assertThat(result, is(true));
    }

    @Test
    public void nonDigitStringShouldThrowException() {

        String invalidISBN = "X123456789";

        try {
            boolean result = validator.checkISBN(invalidISBN);
            fail();
        } catch (Exception e) {
            assertThat(e, instanceOf(IllegalArgumentException.class));
        }
    }
}