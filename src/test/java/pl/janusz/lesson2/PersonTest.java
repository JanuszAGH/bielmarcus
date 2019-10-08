package pl.janusz.lesson2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 08/10/2019. Project; bielmarcus
 */
public class PersonTest {

    @Test
    public void shouldReturnHelloWord() {

//               given
        Person person = new Person();
        String response = "Hello World";
//               when
        String hello = person.hello();
//               then
        assertThat(hello, is(equalTo(response)));
    }
}