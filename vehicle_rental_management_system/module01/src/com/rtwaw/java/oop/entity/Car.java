package com.rtwaw.java.oop.entity;

public class Car extends Vehicle {

    private String type;

    public Car() {
    }

    public Car(String licPlaId, String brand, int dailyRent, String type) {
        super(licPlaId, brand, dailyRent);
        this.type = type;
    }

    @Override
    public float calcRent(int days) {
        float price = this.getDailyRent() * days;
        if (days > 7 && days <= 30) {
            price *= 0.9F;
        } else if (days > 30 && days <= 150) {
            price *= 0.8F;
        } else if (days > 150) {
            price *= 0.7F;
        }
        return (float) (Math.ceil(price * 100) * 0.01);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
