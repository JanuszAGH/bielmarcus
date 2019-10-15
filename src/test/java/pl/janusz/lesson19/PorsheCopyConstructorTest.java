package pl.janusz.lesson19;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 15/10/2019. Project; bielmarcus
 */
public class PorsheCopyConstructorTest {

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
    public void shouldCloneOwner() {

        assertThat(porshe.getOwner(), is(equalTo(marcus)));
    }

    @Test
    public void colorShouldBeNullAtTheBeginning() {

        assertThat(porshe.getColor(), is(equalTo(null)));
    }

    @Test
    public void shouldBeAbleToSetUpColor() {

        porshe.setColor(red);
        assertThat(porshe.getColor(), is(equalTo(red)));
    }

    @Test
    public void shouldClone() throws Exception {

        porshe.setColor(red);
        Porshe petersPorshe = new Porshe(porshe);
        assertThat(petersPorshe.getOwner(), is(equalTo(marcus)));
        assertThat(petersPorshe.getColor(), is(equalTo(red)));
        assertThat(petersPorshe, not((sameInstance(porshe))));
    }

    @Test
    public void shouldClonedActIndependently() throws Exception {

        porshe.setColor(red);
        porshe.setColor(red);
        Porshe petersPorshe = new Porshe(porshe);

        petersPorshe.setColor(black);
        petersPorshe.sellTo(peter);

        assertThat(petersPorshe, not(sameInstance(porshe)));
        assertThat(petersPorshe.getColor(), is(equalTo(black)));
        assertThat(petersPorshe.getOwner(), is(equalTo(peter)));
    }
}