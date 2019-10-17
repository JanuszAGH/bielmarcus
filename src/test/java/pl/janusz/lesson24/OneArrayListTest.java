package pl.janusz.lesson24;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 17/10/2019. Project; bielmarcus
 */
public class OneArrayListTest {

    public static final int INITIAL_CAPACITY = 5;
    private Collection<String> elements;
    private int numberofaddedElements;

    @Before
    public void setUp() throws Exception {

        elements = new ArrayList<>(INITIAL_CAPACITY);

        elements.add("B");
        elements.add("A");
        elements.add("E");
        elements.add("C");
        elements.add("E");
        elements.add("E");

        numberofaddedElements = elements.size();
    }

    @Test
    public void shouldRemoveByIterator() {

        Iterator<String> iterator = elements.iterator();

        assertThat(elements, is(not(emptyCollectionOf(String.class))));
        assertThat(elements, hasSize(numberofaddedElements));
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }

        assertThat(elements, is(emptyCollectionOf(String.class)));
    }

    @Test
    public void shouldRemoveByElements() {

        assertThat(elements, hasSize(numberofaddedElements));
        elements.remove("E");
        assertThat(elements, hasSize(numberofaddedElements - 1));
    }
}