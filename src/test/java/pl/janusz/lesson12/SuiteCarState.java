package pl.janusz.lesson12;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({CarStateSingleTest.class, CarStateTest.class})
public class SuiteCarState {

}