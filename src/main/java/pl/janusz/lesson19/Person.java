package pl.janusz.lesson19;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Janusz Kacki on 15/10/2019. Project; bielmarcus
 */
public class Person {

    private final Sex sex;
    private final Date born;
    private final String name;
    private String surname;

    public Person(Sex sex, String name, int year, int month, int day) {

        this(sex, name, null, year, month, day);
    }

    public Person(Sex sex, String name, String surname, int year, int month, int day) {

        this.sex = sex;
        this.name = name;
        this.surname = surname;
        int realMonth = month - 1;
        this.born = new GregorianCalendar(year, realMonth, day).getTime();
    }

    public static Person newInstance(Person person) {

        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(person.born);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        Person copy = new Person(person.sex, person.name, person.surname, year, month, day);

        return copy;
    }

    public Date getBorn() {

        return born;
    }

    public void changeSurname(String surname) {

        this.surname = surname;
    }

    public Sex getSex() {

        return sex;
    }

    public String getName() {

        return name;
    }

    public String getSurname() {

        return surname;
    }
}
