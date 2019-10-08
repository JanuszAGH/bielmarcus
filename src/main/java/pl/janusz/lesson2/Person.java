package pl.janusz.lesson2;

import pl.janusz.lesson3.Name;

/**
 * Created by Janusz Kacki on 08/10/2019. Project; bielmarcus
 */
public class Person {

    private Name personName;

    public Person(Name personName) {

        this.personName = personName;
    }

    public Person() {

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