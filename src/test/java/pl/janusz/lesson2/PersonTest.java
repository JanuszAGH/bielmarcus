package pl.janusz.lesson2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 08/10/2019. Project; bielmarcus
 */
public class PersonTest {

    private Person person1;
    private Person person2;
    private Person person3;

    @Test
    public void shouldReturnMarcus() {

        Person person = new Person();
        String name = "Marcus";

        String result = person.hello(name);

        String hellomarcus = "Hello " + name;
        assertThat(result, is(equalTo(hellomarcus)));
    }

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