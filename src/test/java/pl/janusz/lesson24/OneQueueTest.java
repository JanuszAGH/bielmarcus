package pl.janusz.lesson24;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 17/10/2019. Project; bielmarcus
 */
public class OneQueueTest {

    private LinkedList<Integer> queue;

    @Before
    public void setUp() throws Exception {

        queue = new LinkedList<>();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
    }

    @Test
    public void shouldThrowExceptionWhenRemovingFromEmptyQueue() {

        queue.clear();

        try {
            Integer remove = queue.remove();
            fail();
        } catch (NoSuchElementException e) {
            assertThat(e, instanceOf(NoSuchElementException.class));
        }
    }

    @Test
    public void shouldThrowExceptionWhenElementingFromEmptyQueue() {

        queue.clear();

        try {
            Integer element = queue.element();
            fail();
        } catch (NoSuchElementException e) {
            assertThat(e, instanceOf(NoSuchElementException.class));
        }
    }

    @Test
    public void shouldReturnNullWhenPeekingFromEmptyQueue() {

        queue.clear();

        Integer peek = queue.peek();
        assertThat(peek, is(equalTo(null)));
    }

    @Test
    public void shouldReturnNullWhenPollingFromEmptyQueue() {

        queue.clear();

        Integer poll = queue.poll();

        assertThat(poll, is(nullValue()));
        assertThat(poll, is(equalTo(null)));
    }

    @Test
    public void shouldPollAllElements() {

        assertThat((queue.size()), is(5));

        assertThat(queue.poll(), is(1));
        assertThat(queue.poll(), is(2));
        assertThat(queue.poll(), is(3));
        assertThat(queue.poll(), is(4));
        assertThat(queue.poll(), is(5));

        assertThat(queue.size(), is(0));
        assertThat(queue.isEmpty(), is(true));
    }

    @Test
    public void shouldRemoveAllElement() {

        queue.clear();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        assertThat(queue.remove(), is(1));
        assertThat(queue.remove(), is(2));
        assertThat(queue.remove(), is(3));
        assertThat(queue.remove(), is(4));
        assertThat(queue.remove(), is(5));
        assertThat(queue.size(), is(0));
    }

    @Test
    public void shouldBeEmptyAtTheBeginningAndNotEmptyAfterAddingElements() {

        queue.clear();

        assertThat(queue, is(emptyCollectionOf(Integer.class)));
        assertThat(queue, hasSize(0));

        queue.add(1);

        assertThat(queue, is(not(emptyCollectionOf(Integer.class))));
        assertThat(queue, hasSize(1));

        queue.offer(2);

        assertThat(queue.size(), is(2));

        int firstRetrieved = queue.remove();
        assertThat(firstRetrieved, is(1));
        int secondRetrieved = queue.remove();
        assertThat(secondRetrieved, is(2));
    }
}