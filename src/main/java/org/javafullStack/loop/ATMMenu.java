package org.javafullStack.loop;

import java.util.Scanner;

public class ATMMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do{
            System.out.println("1. Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");

            choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Your balance is $1000");
                    break;
                case 2:
                    System.out.println("How much would you like to deposit?");
                    break;
                case 3:
                    System.out.println("How much would you like to withdraw?");
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while(choice != 4);
    }
}
