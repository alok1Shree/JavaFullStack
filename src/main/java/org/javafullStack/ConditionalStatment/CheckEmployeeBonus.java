package org.javafullStack.ConditionalStatment;

import java.util.Scanner;

public class CheckEmployeeBonus {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int salary = sc.nextInt();
    int experience = sc.nextInt();
    int bonus = 0;
    if(experience >= 5){
        if(salary >= 50000){
            bonus = (int)(salary * 0.2);
            System.out.println("You are eligible for a bonus of 20% of your salary = " + bonus+salary );
        } else if(salary < 50000) {
            bonus = (int)(salary * 0.1);
            System.out.println("You are eligible for a bonus of 10% of your salary =  " + bonus+salary );
        }
    }else{
        System.out.println("You are not eligible for a bonus.");
    }
    }
}
