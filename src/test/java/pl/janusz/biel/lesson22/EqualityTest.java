package pl.janusz.biel.lesson22;

import org.junit.Test;
import pl.janusz.biel.lesson19.Color;
import pl.janusz.biel.lesson19.Porshe;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 17/10/2019. Project; bielmarcus
 */
public class EqualityTest {

    @Test
    public void stringsShouldBeEqual() {

        String s1 = "Alice";
        String s2 = new String(s1);

        assertThat(s1, is(equalTo(s2)));
        assertThat(s1 == s2, is(false));
        assertThat(s1, not(sameInstance(s2)));
    }

    @Test
    public void primitivesShouldBeEqual() {

        Integer a = Integer.parseInt("303");

        Integer b = 303;

        assertThat(a, is(b));
        assertThat(b, not(sameInstance(a)));
        assertThat(a == b, is(false));
    }

    @Test
    public void intPoolShouldBeUsed() {

        Integer a = 14;
        Integer b = Integer.parseInt("14");

        assertThat(a == b, is(true));
        assertThat(a, is(sameInstance(b)));
        assertThat(a.equals(b), is(true));
        assertThat(a, is(equalTo(b)));
    }

    @Test
    public void carsWithNoColorSetShouldBeEqual() {

        String markus = "Markus";
        Porshe markusPorshe = new Porshe(markus);
        Porshe porshe = new Porshe(markus);

        assertThat(porshe, is(equalTo(markusPorshe)));
    }

    @Test
    public void carsShouldBeEqual() {

        String markus = "Markus";
        Porshe markusPorshe = new Porshe(markus);
        Porshe porshe = new Porshe(markus);
        String red = "red";
        Color redColor = new Color(red);
        porshe.setColor(redColor);
        markusPorshe.setColor(redColor);

        assertThat(porshe, is(equalTo(markusPorshe)));
    }
}