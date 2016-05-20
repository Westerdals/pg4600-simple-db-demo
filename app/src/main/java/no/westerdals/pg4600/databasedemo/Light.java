package no.westerdals.pg4600.databasedemo;

public class Light {
    private int id;
    private float value;
    private int accuracy;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public float getValue() {
        return value;
    }

    public void setValue(final float value) {
        this.value = value;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(final int accuracy) {
        this.accuracy = accuracy;
    }

    @Override
    public String toString() {
        return "Light{" +
                "id=" + id +
                ", value=" + value +
                ", accuracy=" + accuracy +
                '}';
    }
}
