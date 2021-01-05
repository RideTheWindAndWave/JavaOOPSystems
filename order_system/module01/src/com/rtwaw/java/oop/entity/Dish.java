package com.rtwaw.java.oop.entity;

public class Dish {

    private String name;
    private double price;
    private int praise;

    public Dish() {

    }

    public Dish(String name, double price, int praise) {
        this.name = name;
        this.price = price;
        this.praise = praise;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPraise() {
        return praise;
    }

    public void setPraise(int praise) {
        this.praise = praise;
    }

}
