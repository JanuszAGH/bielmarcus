package pl.janusz.lesson19;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Janusz Kacki on 15/10/2019. Project; bielmarcus
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        PorsheTest.class,
        PorsheCopyConstructorTest.class,
        PorsheStaticFactoryTest.class
})
public class PorsheSuite {

}
