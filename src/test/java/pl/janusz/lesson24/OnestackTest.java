package pl.janusz.lesson24;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.LinkedList;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 17/10/2019. Project; bielmarcus
 */
public class OnestackTest {

    private LinkedList<Integer> stack;

    @Before
    public void setUp() throws Exception {

        stack = new LinkedList<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
    }

    @Test
    public void shouldPushandPop() {

        assertThat(stack.pop(), is(5));
        assertThat(stack.pop(), is(4));
        assertThat(stack.pop(), is(3));
        assertThat(stack.pop(), is(2));
        assertThat(stack.pop(), is(1));

        assertThat(stack.isEmpty(), is(true));
        assertThat(stack.size(), is(0));
    }

    @Test
    public void shouldPerformElementFromNonEmptyStack() {

        Integer element = stack.element();
        assertThat(element, is(5));
    }

    @Test
    public void shouldThrowExceptionWhenPerformingElementOnEmptyStack() {

        stack.clear();

        try {
            Integer element = stack.element();
            fail();
        } catch (Exception e) {
            assertThat(e,instanceOf(NoSuchElementException.class));
        }
    }

    @Test
    public void shouldThrowExceptionWhenPoppingFromEmptyStack() {

        stack.clear();

        try {
            Integer pop = stack.pop();
            fail();
        } catch (Exception e) {
            assertThat(e, instanceOf(NoSuchElementException.class));
        }
    }

    @Test
    public void shouldThrowExceptionWhenPerformingElementFromEmptyStack() {

        stack.clear();
    }
}