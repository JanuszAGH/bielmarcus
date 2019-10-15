package pl.janusz.lesson19;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 13/10/2019. Project; bielmarcus
 */
public class CloningTest {

    @Test
    public void shouldCloneArray() {

        String[] array = new String[]{"one", "two", "three"};
        String[] clone = array.clone();
        assertThat(clone, arrayContaining("one", "two", "three"));
        assertThat(clone,not(sameInstance(array)));
    }

    @Test
    public void shouldCloneList() {

        ArrayList<String> list = new ArrayList<>(Arrays.asList("one", "two", "three"));
        List<String> clone = (List<String>) list.clone();
        assertThat(clone, contains("one", "two", "three"));
    }

    @Test
    public void shouldCloneSet() {

        HashSet<String> set = new HashSet<>(Arrays.asList("one", "two", "three"));
        Set<String> clone = (Set<String>) set.clone();
        assertThat(clone, hasItems("one", "two", "three"));
    }
}