package net.forprogrammers;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by Janusz Kacki on 08/10/2019. Project; bielmarcus
 */
public class MyClassTest {

    private IStudent student;
    private String sAName;
    private String sBName;
    private String sASurname;
    private String sBSurname;
    private IStudent studentA;
    private IStudent studentB;
    private MyClass sut;
    private ICreateStudent createStudent;

    @Before
    public void setUp() throws Exception {

        createStudent = Mockito.mock(ICreateStudent.class);
        studentA = Mockito.mock(IStudent.class);
        studentB = Mockito.mock(IStudent.class);

        List<IStudent> students = Arrays.asList(studentA, studentB);

        sAName = "Adam";
        sBName = "Barbara";
        sASurname = "Ant";
        sBSurname = "Brown";

        Mockito
                .when(studentA.getName())
                .thenReturn(sAName);

        Mockito
                .when(studentB.getName())
                .thenReturn(sBName);

        Mockito
                .when(studentA.getSurname())
                .thenReturn(sASurname);
        Mockito
                .when(studentB.getSurname())
                .thenReturn(sBSurname);

        Mockito
                .when(createStudent.getStudents())
                .thenReturn(students);

        sut = new MyClass(createStudent);
    }

    @Test
    public void mocksAreNotNullAsInstances() {

        assertThat(studentA, is(not(equalTo(null))));
        assertThat(studentB, is(not(equalTo(null))));
    }

    @Test
    public void shouldCreateStudents() {

        Mockito
                .verify(createStudent, Mockito.times(1))
                .getStudents();

        List<IStudent> students = createStudent.getStudents();
        assertThat(students.size(), is(2));

        assertThat(students.get(0).getName(), is(sAName));
        assertThat(students.get(1).getName(), is(sBName));
        assertThat(students.get(0).getSurname(), is(sASurname));
        assertThat(students.get(1).getSurname(), is(sBSurname));
    }

    @Test
    public void shouldFindByName() {

        IStudent byName = sut.findByName(sAName);
        assertThat(byName.getName(), is(equalTo(sAName)));
    }

    @Test
    public void shouldFindBySurname() {

        IStudent bySurname = sut.findBySurname(sASurname);
        assertThat(bySurname.getSurname(),is(sASurname));
    }

    @Test
    public void shouldReturnNullWhenStudentDoesntExist() {

        IStudent byName = sut.findByName("Joe");
        assertThat(byName,is(equalTo(null)));

        IStudent bySurname = sut.findBySurname("Doe");
        assertThat(bySurname, is(equalTo(null)));
    }}