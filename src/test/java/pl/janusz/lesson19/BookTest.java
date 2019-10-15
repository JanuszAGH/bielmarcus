package pl.janusz.lesson19;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 13/10/2019. Project; bielmarcus
 */
public class BookTest {

    @Test
    public void shouldHaveSpecifiedName() {

        Book book = new Book("Java");
        assertThat(book, hasProperty("name"));
        assertThat(book, hasProperty("name", is(equalTo("Java"))));
    }
}