package net.forprogrammers;

import java.util.List;
import java.util.function.Predicate;

public class MyClass implements IMyClass {

    private List<IStudent> students;

    public MyClass(ICreateStudent iCreateStudent) {

        this.students = iCreateStudent.getStudents();
    }

    @Override
    public IStudent findByName(String name) {

        Predicate<IStudent> byName = s -> s.getName().equals(name);

        return getStudent(byName);
    }

    @Override
    public IStudent findBySurname(String surname) {

        Predicate<IStudent> bySurname = s -> s.getSurname().equals(surname);

        return getStudent(bySurname);
    }

    @Override
    public int count() {

        return students.size();
    }

    private IStudent getStudent(Predicate<IStudent> criterion) {

        return this.students
                .stream()
                .filter(criterion)
                .findAny()
                .orElse(null);
    }
}
