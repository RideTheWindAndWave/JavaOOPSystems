package com.rtwaw.java.oop.entity;

public class Member {

    private String name;
    private int cardId;
    private String password;
    private int points;
    private String registrationDate;

    public Member() {
    }

    public Member(String name, int cardId, String password, int points, String registrationDate) {
        this.name = name;
        this.cardId = cardId;
        this.password = password;
        this.points = points;
        this.registrationDate = registrationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

}
