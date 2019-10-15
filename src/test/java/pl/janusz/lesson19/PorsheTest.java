package pl.janusz.lesson19;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 13/10/2019. Project; bielmarcus
 */
public class PorsheTest {

    private String marcus;
    private String peter;
    private Porshe porshe;

    @Before
    public void setUp() throws Exception {

        marcus = "Marcus";
        peter = "Peter";
        porshe = new Porshe(marcus);
    }

    @Test
    public void shouldclonePorsche() throws Exception {

        Porshe petersPorshe = porshe.clone();

        assertThat(porshe, hasProperty("owner", is(marcus)));
        assertThat(porshe, hasProperty("owner", is(marcus)));
        assertThat(petersPorshe, not(sameInstance(porshe)));
    }

    @Test
    public void whenSoldshouldBePetersPorshe() throws CloneNotSupportedException {

        Porshe petersPorshe = porshe.clone();
        petersPorshe.sellTo(peter);

        assertThat(petersPorshe, not(sameInstance(porshe)));
        assertThat(porshe, hasProperty("owner", is(equalTo(marcus))));
        assertThat(petersPorshe, hasProperty("owner", is(equalTo(peter))));
    }

    @Test
    public void shouldCloneColor() throws Exception {

        Color color = porshe.getColor();
        assertThat(color, is(equalTo(null)));
        Color red = new Color("red");
        Color black = new Color("black");
        porshe.setColor(red);
        assertThat(porshe.getColor(), is(equalTo(red)));

        Porshe petersPorshe = porshe.clone();
        assertThat(petersPorshe.getColor(), is(equalTo(red)));
        petersPorshe.setColor(black);
        assertThat(petersPorshe.getColor(), is(equalTo(black)));
        assertThat(porshe.getColor(), is(equalTo(red)));
    }
}