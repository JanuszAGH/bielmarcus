package pl.janusz;

/**
 * Created by Janusz Kacki on 08/10/2019. Project; bielmarcus
 */
public class Car {

    private String make;
    private String model;
    private String color;
    private int year;

    public Car(String make, String model, int year) {

        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getColor() {

        return color;
    }

    public void setColor(String color) {

        this.color = color;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (getYear() != car.getYear()) return false;
        if (!getMake().equals(car.getMake())) return false;
        return getModel().equals(car.getModel());
    }

    @Override
    public int hashCode() {

        int result = getMake().hashCode();
        result = 31 * result + getModel().hashCode();
        result = 31 * result + getYear();
        return result;
    }

    @Override
    public String toString() {

        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }

    public String getMake() {

        return make;
    }

    public void setMake(String make) {

        this.make = make;
    }

    public String getModel() {

        return model;
    }

    public void setModel(String model) {

        this.model = model;
    }

    public int getYear() {

        return year;
    }

    public void setYear(int year) {

        this.year = year;
    }
}
