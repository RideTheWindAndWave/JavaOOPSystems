package com.rtwaw.java.oop.entity;

import com.rtwaw.java.oop.utils.OptimisedScanner;

import java.text.SimpleDateFormat;
import java.util.*;


public class MemberBusiness {

    private List<Member> memberList = new ArrayList<>();

    //Start the menu
    private void menu() {
        System.out.println("********Welcome to the supermarket membership management system(Powered by Hengjia Liu)********");
        System.out.println("\t1. Accumulate points\t\t2. Points redemptio\t\t3. Query the remaining points");
        System.out.println("\t4. Change the password\t\t5. Open the card\t\t6. Exit the System");
        System.out.println("***********************************************************************************************");
    }

    public void start() {
        do {
            menu();
            System.out.print("Please select the business number: ");
            int choose = OptimisedScanner.getInt();
            switch (choose) {
                case 1:
                    if (accumulatePoints()) {
                        System.out.println("The points were accumulated successfully!");
                    } else {
                        System.out.println("The points have failed cumulatively!");
                    }
                    continue;
                case 2:
                    if (pointsRedemption()) {
                        System.out.println("The redemption of points was successful!");
                    } else {
                        System.out.println("The redemption of points failed!");
                    }
                    continue;
                case 3:
                    displayPoints();
                    continue;
                case 4:
                    modifyPassword();
                    continue;
                case 5:
                    boolean isSuccessful = registered();
                    continue;
                case 6:
                    System.out.println("Thank you for your use and welcome to visit next time!");
                    break;
                default:
                    System.out.print("Your operation is wrong, please re-select: ");
                    continue;
            }
            break;
        } while (true);
    }

    private boolean accumulatePoints() {
        System.out.print("Please enter your membership card number: ");
        int cardId = OptimisedScanner.getInt();
        System.out.print("Please enter your password: ");
        String password = OptimisedScanner.getString();
        Member member = searchMember(cardId, password);
        if (member != null) {
            System.out.print("Please enter your amount for this purchase: ");
            int thisPoints = OptimisedScanner.getInt();
            member.setPoints(member.getPoints() + thisPoints);
            return true;
        } else {
            System.out.println("Sorry, the membership card does not exist!");
            return false;
        }
    }

    private boolean pointsRedemption() {
        System.out.print("Please enter your membership card number: ");
        int cardId = OptimisedScanner.getInt();
        System.out.print("Please enter your password: ");
        String password = OptimisedScanner.getString();
        Member member = searchMember(cardId, password);
        if (member != null) {
            System.out.print("Please enter the points you need to credit for this purchase: ");
            int deductPoints = OptimisedScanner.getInt();
            if (member.getPoints() >= deductPoints) {
                member.setPoints(member.getPoints() - deductPoints);
                System.out.println("You offset " + deductPoints / 100.0 * 0.1 + "yuan this time");
                return true;
            } else {
                System.out.println("Sorry, there are not enough points to redeem!");
                return false;
            }
        } else {
            return false;
        }
    }

    private void displayPoints() {
        System.out.print("Please enter your membership card number: ");
        int cardId = OptimisedScanner.getInt();
        System.out.print("Please enter your password: ");
        String password = OptimisedScanner.getString();
        Member member = searchMember(cardId, password);
        if (member != null) {
            System.out.println("Card Id\tName\tRemaining points\tDate of opening");
            System.out.println(member.getCardId() + "\t" + member.getName() + "\t" + member.getPoints() + "\t" + member.getRegistrationDate());
        }
    }

    private void modifyPassword() {
        System.out.print("Please enter your membership card number: ");
        int cardId = OptimisedScanner.getInt();
        System.out.print("Please enter your old password: ");
        String password = OptimisedScanner.getString();
        Member member = searchMember(cardId, password);
        if (member != null) {
            System.out.print("Please enter your new password: ");
            String newPassword = OptimisedScanner.getString();
            member.setPassword(newPassword);
            System.out.println("The password was modified successfully!");
        }
    }

    private boolean registered() {
        Member member = new Member();
        System.out.print("Please enter your name: ");
        member.setName(OptimisedScanner.getString());
        member.setCardId(getRandomCardId());
        System.out.print("Please enter your password: ");
        String password;
        boolean isCorrect = false;
        do {
            password = OptimisedScanner.getString();
            if (password.length() < 6) {
                System.out.print("The password cannot be less than 6 bits! Please re-enter: ");
                isCorrect = false;
            } else {
                isCorrect = true;
                member.setPassword(password);
            }
        } while (!isCorrect);
        member.setPoints(100);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        member.setRegistrationDate(sdf.format(date));
        if (member.getName() != null && member.getPassword() != null && member.getCardId() != 0) {
            System.out.println("Congratulations on the success of your card opening!");
            System.out.println("The system gives you 100 points and your membership card is " + member.getCardId());
            memberList.add(member);
            return true;
        } else {
            System.out.println("The card opening failed!");
            return false;
        }
    }

    private int getRandomCardId() {
        Random random = new Random();
        int id = random.nextInt(99999999);
        boolean isSame = false;
        do {
            for (Member e : memberList
                    ) {
                if (e.getCardId() == id) {
                    isSame = true;
                }
            }
            if (isSame) {
                id = random.nextInt(99999999);
            }
        } while (isSame);
        return id;
    }

    private Member searchMember(int cardId, String password) {
        for (Member e : memberList
                ) {
            if (e.getCardId() == cardId && e.getPassword().equals(password)) {
                return e;
            }
        }
        System.out.println("Sorry, the cardId or password is incorrect!");
        return null;
    }

}