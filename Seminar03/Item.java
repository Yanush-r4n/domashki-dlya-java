package Seminar03;

import java.util.function.DoubleUnaryOperator;

public class Item {
    private String name;
    private Double price;
    private String grade;

    public Item(String name, Double price, String grade) {
        this.name = name;
        this.price = price;
        this.grade = grade;
    }
    public Item() {
    }

    public String getName() {
        return name;
    }
    public Double getPrice() {
        return price;
    }
    public String getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return String.format(
                "(Name: %s; Price: %.2f; Grade: %s)", name, price, grade
        );
    }


}
