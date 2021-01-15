package com.rtwaw.java.oop.utils;

import java.util.Scanner;

public class OptimisedScanner {

    public static String getString(){
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public static int getInt(){
        Boolean boo = true;
        int number = 0;
        while (boo) {
            Scanner input = new Scanner(System.in);
            try {
                number = input.nextInt();
                boo = false;
            } catch (Exception e) {
                System.out.print("Please enter the correct number: ");
            }
        }
        return number;
    }

}
