package com.rtwaw.java.oop;

import com.rtwaw.java.oop.business_logic.VehicleBusiness;
import com.rtwaw.java.oop.entity.Vehicle;
import com.rtwaw.java.oop.utils.OptimisedScanner;

public class VehicleRentalSystem {

    public static void main(String[] args) {
        VehicleBusiness vehicleBusiness = new VehicleBusiness();
        System.out.println("********Welcome to the vehicle rental company(Powered by Hengjia Liu)********");
        System.out.print("Please select the model you want to rent(1. Car    2. Bus): ");
        int vehicleType = OptimisedScanner.getInt();
        String brand = "";
        int numOfSeats = 0;
        String type = "";
        Boolean isSelSuc = false;
        while (!isSelSuc) {
            switch (vehicleType) {
                case 1:
                    System.out.print("Please select the car brand you want to rent(1. Bmw   2. Buick): ");
                    int choose = OptimisedScanner.getInt();
                    if (choose == 1) {
                        brand = "Bmw";
                        System.out.print("Please select the type of car you want to rent(1. 550i    2. X6): ");
                        type = (OptimisedScanner.getInt() == 1) ? "550i" : "X6";
                    } else {
                        brand = "Buick";
                        System.out.print("Please select the type of car you want to rent(1. GL8    2. Lin Meng Avenue): ");
                        type = (OptimisedScanner.getInt() == 1) ? "GL8" : "Lin Meng Avenue";
                    }
                    isSelSuc = true;
                    break;
                case 2:
                    System.out.print("Please select the car brand you want to rent(1. Gold Cup   2. Golden Dragon): ");
                    brand = (OptimisedScanner.getInt() == 1) ? "Gold Cup" : "Golden Dragon";
                    System.out.print("Please select the number of car seats you would like to rent(1. 16 seats    2. 34 seats): ");
                    numOfSeats = (OptimisedScanner.getInt() == 1) ? 16 : 34;
                    isSelSuc = true;
                    break;
                default:
                    System.out.print("Please enter the numbers we already have: ");
                    break;
            }
        }

        //Initialize the vehicle information
        vehicleBusiness.init();
        Vehicle vehicle = vehicleBusiness.rentVehicle(brand, numOfSeats, type);
        System.out.print("Please enter the number of days you want to rant a car: ");
        int days = OptimisedScanner.getInt();
        float price = vehicle.calcRent(days);
        System.out.println("The license plate number assigned to you is: " + vehicle.getLicPlaId());
        System.out.println("The rental fee you will have to pay is: " + price + "RMB");
    }

}
