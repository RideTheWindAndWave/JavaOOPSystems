package com.rtwaw.java.oop.entity;

public class Order {

    private String name;
    private String mealInformation;
    private int time;
    private String address;
    private double totalAmount;
    private int state;

    public Order() {
    }

    public Order(String name, String mealInformation, int time, String address, double totalAmount, int state) {
        this.name = name;
        this.mealInformation = mealInformation;
        this.time = time;
        this.address = address;
        this.totalAmount = totalAmount;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMealInformation() {
        return mealInformation;
    }

    public void setMealInformation(String mealInformation) {
        this.mealInformation = mealInformation;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

}
