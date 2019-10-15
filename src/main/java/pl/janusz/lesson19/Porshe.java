package pl.janusz.lesson19;

/**
 * Created by Janusz Kacki on 13/10/2019. Project; bielmarcus
 */
public class Porshe implements Cloneable {

    private String owner;
    private Color color;

    public Porshe(String owner) {

        this.owner = owner;
    }

    public Porshe(Porshe porshe) {

        this.owner = porshe.owner;
        this.color = porshe.color;
    }

    public static Porshe newInstance(Porshe porshe) {

        Porshe result = new Porshe(porshe.getOwner());
        result.setColor(porshe.getColor());

        return result;
    }

    public Color getColor() {

        return color;
    }

    public void setColor(Color color) {

        this.color = color;
    }

    public String getOwner() {

        return owner;
    }

    public void drive() {

        System.out.println("Porshe is driving...");
    }

    public String asString() {

        return "Porshe of " + this.owner;
    }

    @Override
    protected Porshe clone() throws CloneNotSupportedException {

        Porshe cloned = (Porshe) super.clone();
        if (this.color != null) {
            cloned.color = this.color.clone();
        }

        return cloned;
    }

    public void sellTo(String ownersName) {

        this.owner = ownersName;
    }
}
