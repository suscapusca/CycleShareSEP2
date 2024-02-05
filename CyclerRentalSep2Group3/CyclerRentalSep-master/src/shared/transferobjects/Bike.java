package src.shared.transferobjects;

import java.io.Serializable;

public class Bike implements Serializable {
    private int id;
    private String brand;
    private String category;
    private boolean availability;
    private int year;
    private float price;

    public Bike(String brand, String category, boolean availability, int year, float price) {
        this.brand = brand;
        this.category = category;
        this.availability = availability;
        this.year = year;
        this.price = price;
    }

    public Bike(int id, String brand, String category, boolean availability, int year, float price) {
        this.id = id;
        this.brand = brand;
        this.category = category;
        this.availability = availability;
        this.year = year;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
