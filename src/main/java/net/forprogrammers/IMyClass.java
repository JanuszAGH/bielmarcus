package net.forprogrammers;

/**
 * Created by Janusz Kacki on 08/10/2019. Project; bielmarcus
 */
public interface IMyClass {

    // zwraca studenta o podanym name lub null
    IStudent findByName(String name);

    // zwraca studenta o podanym surname lub null
    IStudent findBySurname(String surname);

    //zwraca liczbę studentów
    int count();
}
