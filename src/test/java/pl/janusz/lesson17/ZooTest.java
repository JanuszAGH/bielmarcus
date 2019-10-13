package pl.janusz.lesson17;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 13/10/2019. Project; bielmarcus
 */
public class ZooTest {

    @Test
    public void shouldfeedAllAnimals() {

        Zoo zoo = new Zoo();
        Animal[] animals = new Animal[]{new Dog(), new Gorilla(), new Lion(), new Tiger()};
        
    }
}