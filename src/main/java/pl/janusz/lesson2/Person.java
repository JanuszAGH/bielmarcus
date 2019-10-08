package pl.janusz.lesson2;

import pl.janusz.lesson3.Name;

/**
 * Created by Janusz Kacki on 08/10/2019. Project; bielmarcus
 */
public class Person {

    private static int personsCreated = 0;
    private Name personName;

    public Person(Name personName) {

        this.personName = personName;
        Person.personsCreated++;
    }

    public Person() {

        this(null);
    }

    public static int numberOfPersons() {

        return Person.personsCreated;
    }

    public String hello(String name) {

        return "Hello " + name;
    }

    public String hello() {

        return "Hello World";
    }

    public Name getPersonName() {

        return personName;
    }
}
