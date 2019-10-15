package pl.janusz.lesson19;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 15/10/2019. Project; bielmarcus
 */
public class PersonTest {

    @Test
    public void shouldSetDOB() {

        Person agata = new Person(Sex.FEMALE, "Agata", "Kącka", 2009, 11, 9);

        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(agata.getBorn());
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        assertThat(dayOfWeek, is(equalTo(Calendar.MONDAY)));
        assertThat(day, is(equalTo(9)));
        assertThat(month, is(equalTo(11)));
        assertThat(year, is(equalTo(2009)));
    }
}