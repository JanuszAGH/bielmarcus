package pl.janusz.biel.lesson19;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 15/10/2019. Project; bielmarcus
 */
public class PorsheStaticFactoryTest {

    private Porshe porshe;
    private String marcus;
    private Color red;
    private Color black;
    private String peter;

    @Before
    public void setUp() throws Exception {

        marcus = "Marcus";
        String marcus = this.marcus;
        porshe = new Porshe(marcus);
        red = new Color("red");
        black = new Color("black");
        peter = "Peter";
    }

    @Test
    public void shouldClone() throws Exception {

        porshe.setColor(red);
        Porshe petersPorshe = Porshe.newInstance(porshe);
        assertThat(petersPorshe.getOwner(), is(equalTo(marcus)));
        assertThat(petersPorshe.getColor(), is(equalTo(red)));
        assertThat(petersPorshe, not((sameInstance(porshe))));
    }

    @Test
    public void shouldClonedActIndependently() throws Exception {

        porshe.setColor(red);
        porshe.setColor(red);
        Porshe petersPorshe = Porshe.newInstance(porshe);

        petersPorshe.setColor(black);
        petersPorshe.sellTo(peter);

        assertThat(petersPorshe, not(sameInstance(porshe)));
        assertThat(petersPorshe.getColor(), is(equalTo(black)));
        assertThat(petersPorshe.getOwner(), is(equalTo(peter)));
    }
}