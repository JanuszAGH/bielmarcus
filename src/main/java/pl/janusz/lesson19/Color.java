package pl.janusz.lesson19;

/**
 * Created by Janusz Kacki on 14/10/2019. Project; bielmarcus
 */
public class Color implements Cloneable {

    private String color;

    public Color() {

        this(null);
    }

    public Color(String color) {

        this.color = color;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Color color1 = (Color) o;

        return getColor() != null ? getColor().equals(color1.getColor()) : color1.getColor() == null;
    }

    @Override
    protected Color clone() throws CloneNotSupportedException {

        return (Color) super.clone();
    }

    @Override
    public int hashCode() {

        return getColor() != null ? getColor().hashCode() : 0;
    }

    @Override
    public String toString() {

        return "Color{" +
                "color='" + color + '\'' +
                '}';
    }

    public String getColor() {

        return color;
    }

    public void setColor(String color) {

        this.color = color;
    }
}
