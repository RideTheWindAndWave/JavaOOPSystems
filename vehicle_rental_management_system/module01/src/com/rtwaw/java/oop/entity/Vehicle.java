package com.rtwaw.java.oop.entity;

public abstract class Vehicle {

    //licPlaId brand dailyRent
    private String licPlaId;
    private String brand;
    private int dailyRent;

    public Vehicle() {
    }

    public Vehicle(String licPlaId, String brand, int dailyRent) {
        this.licPlaId = licPlaId;
        this.brand = brand;
        this.dailyRent = dailyRent;
    }

    //Abstract methods: Calculate the rent --> Rent is calculated based on the lease period.
    public abstract float calcRent(int days);

    public String getLicPlaId() {
        return licPlaId;
    }

    public void setLicPlaId(String licPlaId) {
        this.licPlaId = licPlaId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getDailyRent() {
        return dailyRent;
    }

    public void setDailyRent(int dailyRent) {
        this.dailyRent = dailyRent;
    }
}
