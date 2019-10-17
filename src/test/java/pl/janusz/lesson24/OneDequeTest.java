package pl.janusz.lesson24;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 17/10/2019. Project; bielmarcus
 */
public class OneDequeTest {

    private Deque<Integer> deque;

    @Before
    public void setUp() throws Exception {

        deque = new ArrayDeque<>(3);

        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(4);
        deque.add(5);
    }

    @Test
    public void shouldBeArrayDeque() {

        assertThat(deque, hasSize(5));

        assertThat(deque.add(6), is(true));
        assertThat(deque.add(6), is(true));
        assertThat(deque.add(6), is(true));
    }

    @Test
    public void shoudBeLinkedListDeque() {

        Deque<Integer> deque = new LinkedList<>();
    }
}