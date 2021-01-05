package com.rtwaw.java.oop.entity;

import com.rtwaw.java.oop.utils.OptimisedScanner;

public class Restaurant {

    private Dish[] dishes;
    private Order[] orders;

    public Restaurant() {
    }

    public Restaurant(Dish[] dishes, Order[] orders) {
        this.dishes = dishes;
        this.orders = orders;
    }

    public void orderAMeal() {
        boolean isCanAdd = false;
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == null || orders[i].getName() == null) {
                isCanAdd = true;//Orders are not full and meals can be ordered
                System.out.print("Please enter your name: ");
                String name = OptimisedScanner.getString();
                //Cycle through the output of vegetable information
                System.out.println("Serial number\t\tDish name\t\tPrice");
                for (int j = 0; j < dishes.length; j++) {
                    String praise = (dishes[j].getPraise() == 0 ? "" : dishes[j].getPraise() + " Praise");
                    System.out.println((j + 1) + "\t\t" + dishes[j].getName() + "\t\t" + dishes[j].getPrice() + "\t\t" + praise);
                }
                System.out.print("Please enter the number of the dish you are asking for: ");
                int no = OptimisedScanner.getInt();
                while (no < 1 || no > dishes.length) {
                    System.out.print("We don\'t have this dish, please choose again: ");
                    no = OptimisedScanner.getInt();
                }
                //The number of servings to order
                System.out.print("Please enter the number of servings to order: ");
                int number = OptimisedScanner.getInt();
                //Input and judgment of delivery time
                System.out.print("Please enter the delivery time(Meal delivery time is only between 10 and 20 o\'clock): ");
                int time = OptimisedScanner.getInt();
                while (time < 10 || time > 20) {
                    System.out.print("Your input is incorrect, please enter an integer between 10 and 20: ");
                    time = OptimisedScanner.getInt();
                }
                //Delivery address
                System.out.print("Please enter your address: ");
                String address = OptimisedScanner.getString();
                //Output the order information to the user to see
                System.out.println("The order was successful!");
                //Dish information
                String dishInformation = dishes[no - 1].getName() + " x" + number;
                System.out.println("You ordered: " + dishInformation);
                System.out.println("Delivery time: " + time + " o\'clock");
                //Total amount
                double dishPrice = dishes[no - 1].getPrice() * number;
                double deliveryFee = (dishPrice > 50) ? 0 : 6;
                double totalAmount = dishPrice + deliveryFee;
                System.out.println("Meals: " + dishPrice + " RMB; Delivery fee: " + deliveryFee
                        + "; Total amount: " + totalAmount + " RMB");
                //Add information to the order information
                orders[i] = new Order(name, dishInformation, time, address, totalAmount, 0);
                //At the eng of this order, jump out of the loop
                break;
            }
        }
        if (!isCanAdd) {
            System.out.println("Sorry, your bag is full!");
        }
    }

    public void checkTheBag() {
        System.out.println("Serial number\t\tname\t\tMeal information\t\tTime\t\tAddress\t\tTotal amount\t\tState");
        for (int i = 0; i < orders.length && orders[i] != null; i++) {
            if (orders[i].getName() != null) {
                String time = orders[i].getTime() + " o\'clock";
                String state = (orders[i].getState() == 0) ? "Booked" : "Completed";
                System.out.println((i + 1) + "\t\t" + orders[i].getName() + "\t\t"
                        + orders[i].getMealInformation() + "\t\t" + time + "\t\t"
                        + orders[i].getAddress() + "\t\t" + orders[i].getTotalAmount() + " RMB\t\t" + state
                );
            }
        }
    }

    public void receiveTheOrder() {
        boolean isFind = false;
        System.out.print("Please enter the order number you want to sign: ");
        int signNo = OptimisedScanner.getInt();
        for (int i = 0; i < orders.length && orders[i] != null; i++) {
            if (orders[i].getName() != null && orders[i].getState() == 0 && i == signNo - 1) {
                isFind = true;
                orders[i].setState(1);
                System.out.println("The order was signed successfully!");
            } else if (orders[i].getName() != null && orders[i].getState() == 1 && i == signNo - 1) {
                isFind = true;
                System.out.println("The order you selected has been signed and cannot be re-signed!");
            }
        }
        if (!isFind) {
            System.out.println("The order you selected does not exist!");
        }
    }

    public void deleteTheOrder() {
        boolean isFind = false;
        System.out.print("Please enter the order number you want to delete: ");
        int deleteNo = OptimisedScanner.getInt();
        for (int i = 0; i < orders.length && orders[i] != null; i++) {
            if (orders[i].getName() != null && orders[i].getState() == 0 && i == deleteNo - 1) {
                isFind = true;
                System.out.println("The order you selected was not signed and cannot be deleted!");
            } else if (orders[i].getName() != null && orders[i].getState() == 1 && i == deleteNo - 1) {
                isFind = true;
                for (int j = i; j < orders.length - 1; j++) {
                    if (orders[j + 1] != null) {
                        orders[j].setName(orders[j + 1].getName());
                        orders[j].setMealInformation(orders[j + 1].getName());
                        orders[j].setTime(orders[j + 1].getTime());
                        orders[j].setAddress(orders[j + 1].getAddress());
                        orders[j].setTotalAmount(orders[j + 1].getTotalAmount());
                        orders[j].setState(orders[j + 1].getState());
                    } else {
                        orders[j].setName(null);
                        orders[j].setMealInformation(null);
                        orders[j].setTime(0);
                        orders[j].setAddress(null);
                        orders[j].setTotalAmount(0);
                        orders[j].setState(0);
                        break;
                    }
                }
                if (orders[orders.length - 1] != null) {
                    orders[orders.length - 1].setName(null);
                    orders[orders.length - 1].setMealInformation(null);
                    orders[orders.length - 1].setTime(0);
                    orders[orders.length - 1].setAddress(null);
                    orders[orders.length - 1].setTotalAmount(0);
                    orders[orders.length - 1].setState(0);
                }
                System.out.println("The order was deleted successfully!");
            }
        }
        if (!isFind) {
            System.out.println("The order you selected does not exist!");
        }
    }

    public void likeIt() {
        //Cycle through the output of vegetable information
        System.out.println("Serial number\t\tDish name\t\tPrice");
        for (int j = 0; j < dishes.length; j++) {
            String praise = (dishes[j].getPraise() == 0 ? "" : dishes[j].getPraise() + " Praise");
            System.out.println((j + 1) + "\t\t" + dishes[j].getName() + "\t\t" + dishes[j].getPrice() + "\t\t" + praise);
        }
        //Like it
        System.out.print("Please enter the serial number of the dish you want to praise: ");
        int praiseNo = OptimisedScanner.getInt();
        while (praiseNo < 1 || praiseNo > orders.length) {
            System.out.print("Our shop does not have this dish, can not like! Please re-enter a food serial number: ");
            praiseNo = OptimisedScanner.getInt();
        }
        dishes[praiseNo - 1].setPraise(dishes[praiseNo - 1].getPraise() + 1);
        System.out.println("Like success!");
    }

    //Getter and Setter
    public Dish[] getDishes() {
        return dishes;
    }

    public void setDishes(Dish[] dishes) {
        this.dishes = dishes;
    }

    public Order[] getOrders() {
        return orders;
    }

    public void setOrders(Order[] orders) {
        this.orders = orders;
    }

}
