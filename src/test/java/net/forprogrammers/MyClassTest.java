package net.forprogrammers;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class MyClassTest {

    @Parameterized.Parameter(value = 0)
    public static String name;
    @Parameterized.Parameter(value = 1)
    public static String surname;
    @Parameterized.Parameter(value = 2)
    public static IStudent student;

    private static String sAName = "Adam";
    private static String sBName = "Barbara";
    private static String sASurname = "Ant";
    private static String sBSurname = "Brown";
    private static IStudent studentA = Mockito.mock(IStudent.class);
    private static IStudent studentB = Mockito.mock(IStudent.class);

    private MyClass sut;
    private ICreateStudent createStudent;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][]{
                {sAName, sASurname, studentA},
                {sBName, sBSurname, studentB}
        });
    }

    @Before
    public void setUp() throws Exception {

        createStudent = Mockito.mock(ICreateStudent.class);

        List<IStudent> students = Arrays.asList(studentA, studentB);

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
    public void shouldDoFindingByName() {

        IStudent byName = sut.findByName(name);
        assertThat(byName.getName(), is(equalTo(student.getName())));
    }

    @Test
    public void shouldfindingBySurname() {

        IStudent bySurname = sut.findBySurname(surname);
        assertThat(bySurname.getSurname(), is(equalTo(student.getSurname())));
    }

    @Ignore
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

        assertThat(studentA, is(not(equalTo(null))));
        assertThat(studentB, is(not(equalTo(null))));
    }

    @Test
    public void shouldReturnNullWhenStudentDoesntExist() {

        IStudent byName = sut.findByName("Joe");
        assertThat(byName, is(equalTo(null)));

        IStudent bySurname = sut.findBySurname("Doe");
        assertThat(bySurname, is(equalTo(null)));
    }
}