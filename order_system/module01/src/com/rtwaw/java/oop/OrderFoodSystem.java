package com.rtwaw.java.oop;

import com.rtwaw.java.oop.entity.Dish;
import com.rtwaw.java.oop.entity.Order;
import com.rtwaw.java.oop.entity.Restaurant;
import com.rtwaw.java.oop.utils.OptimisedScanner;

public class OrderFoodSystem {

    //Define the data body: restaurant(dishes and orders)
    private static Restaurant restaurant = new Restaurant(
            new Dish[]{
                    new Dish("Red ribbon fish", 38.0, 0),
                    new Dish("Fish and meat silk", 20.0, 0),
                    new Dish("Time vegetables", 10.0, 0)
            }
            , new Order[4]//4 is the max number of order
    );

    public static void main(String[] args) {
        //Initialize two order information
        dataInitialization();

        //Build the overall process framework for project
        implementMenuSwitching();
    }

    //Level 1
    private static void dataInitialization() {
        Order order01 = new Order("San Zhang", "Red ribbon fish", 10, "223 Kirin Road", 76, 0);
        Order order02 = new Order("Si Li", "Fish and meat silk", 13, "207 Tian Cheng Road", 26, 1);
        restaurant.getOrders()[0] = order01;
        restaurant.getOrders()[1] = order02;
    }

    //Level 1
    private static void implementMenuSwitching() {
        int num = -1;//The main menu is repeated at num = 0;
        System.out.println("Welcome to the ordering system(Powered by Hengjia Liu)");
        boolean flag = false;//A flag that records whether the user is exiting
        do {
            System.out.println("********************");
            System.out.println("1. Order a meal");
            System.out.println("2. Check the bag");
            System.out.println("3. Receive the order");
            System.out.println("4. Delete the order");
            System.out.println("5. Like it");
            System.out.println("6. Exit the system");
            System.out.println("********************");
            System.out.print("Please select: ");
            int choose = OptimisedScanner.getInt();
            switch (choose) {
                case 1:
                    System.out.println("*****Order a meal*****");
                    restaurant.orderAMeal();
                    break;
                case 2:
                    System.out.println("*****Check the bag*****");
                    restaurant.checkTheBag();
                    break;
                case 3:
                    System.out.println("*****Receive the order*****");
                    restaurant.receiveTheOrder();
                    break;
                case 4:
                    System.out.println("*****Delete the order*****");
                    restaurant.deleteTheOrder();
                    break;
                case 5:
                    System.out.println("*****Like it*****");
                    restaurant.likeIt();
                    break;
                case 6:
                    //Exit the system
                    flag = true;
                    break;
                default:
                    //Exit the program
                    System.exit(0);
                    break;
            }
            if (!flag) {
                System.out.print("Please enter 0 back: ");
                num = OptimisedScanner.getInt();
            } else {
                break;
            }
        } while (num == 0);
        System.out.println("Thanks for using, welcome to come next time!");
    }

}
