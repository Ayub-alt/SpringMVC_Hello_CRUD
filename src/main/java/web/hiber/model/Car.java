package web.hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;

    @Column(name = "modelYear")
    private int modelYear;

    public Car(String model, int series, int modelYear) {
        this.model = model;
        this.series = series;
        this.modelYear = modelYear;
    }

    public Car() {
    }

    ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    @Override
    public String toString() {
        return "Car{ " +
                "modelYear = " + modelYear +
                ", series = " + series +
                ", model = '" + model + '\'' +
                '}';
    }
}
