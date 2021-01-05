package com.rtwaw.java.oop.business_logic;

import com.rtwaw.java.oop.entity.Bus;
import com.rtwaw.java.oop.entity.Car;
import com.rtwaw.java.oop.entity.Vehicle;

public class VehicleBusiness {

    //Initialization of vehicle information
    Vehicle[] vehicles = new Vehicle[8];

    public void init() {
        //(String licPlaId, String brand, int dailyRent, String type)
        vehicles[0] = new Car("豫L79654", "Bmw", 599, "550i");
        vehicles[1] = new Car("豫R88888", "Bmw", 799, "X6");
        vehicles[2] = new Car("豫Y96584", "Buick", 399, "Lin Meng Avenue");
        vehicles[3] = new Car("豫R36589", "Buick", 499, "GL8");
        vehicles[4] = new Bus("豫P85796", "Gold Cup", 699, 16);
        vehicles[5] = new Bus("豫U90876", "Gold Cup", 1199, 34);
        vehicles[6] = new Bus("豫T66666", "Golden Dragon", 799, 16);
        vehicles[7] = new Bus("豫Y85754", "Golden Dragon", 999, 34);
    }

    public Vehicle rentVehicle(String brand, int numOfSeats, String type) {
        Vehicle vehicle = null;
        for (Vehicle e : vehicles
                ) {
            if (e instanceof Car) {
                Car car = (Car) e;
                if (car.getBrand().equals(brand) && car.getType().equals(type)) {
                    vehicle = car;
                    break;
                }
            } else {
                Bus bus = (Bus) e;
                if (bus.getBrand().equals(brand) && bus.getNumOfSeats() == numOfSeats) {
                    vehicle = bus;
                    break;
                }
            }
        }
        return vehicle;
    }

}
