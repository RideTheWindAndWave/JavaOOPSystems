package com.rtwaw.java.oop.entity;

public class Bus extends Vehicle {

    private int numOfSeats;

    public Bus() {
    }

    public Bus(String licPlaId, String brand, int dailyRent, int numOfSeats) {
        super(licPlaId, brand, dailyRent);
        this.numOfSeats = numOfSeats;
    }

    @Override
    public float calcRent(int days) {
        float price = this.getDailyRent() * days;
        if (days >= 3 && days < 7) {
            price *= 0.9F;
        } else if (days >= 7 && days < 30) {
            price *= 0.8F;
        } else if (days >= 30 && days < 150) {
            price *= 0.7F;
        } else if (days >= 150) {
            price *= 0.6F;
        }
        return (float) (Math.ceil(price * 100) * 0.01);
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

}
