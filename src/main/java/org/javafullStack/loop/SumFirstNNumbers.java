package org.javafullStack.loop;

import java.util.Scanner;

public class SumFirstNNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = input.nextInt();
        int i=1;
        int sum = 0;
       while(i<=num){
           sum+=i;
           i++;
       }
       System.out.println(sum);
    }
}
